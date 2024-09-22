package br.dev.kuhn.jackchat.v1.conversation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.dev.kuhn.jackchat.v1.conversation.models.cards.CardMessage;
import br.dev.kuhn.jackchat.v1.conversation.properties.ChatwootProperties;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums.ConversationStatus;

@Service
public class ConversationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatwootProperties chatwootProperties;

    private Map<String, Object> sendMessage(int account, int conversation, Object data) {
        return sendRequest(account, conversation, data, "messages");
    }

    private Map<String, Object> sendRequest(int account, int conversation, Object data,
            String endpoint) {
        String url = String.format("%s/api/v1/accounts/%s/conversations/%s/%s", chatwootProperties.getApiUrl(), account,
                conversation, endpoint);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        headers.set("api_access_token", chatwootProperties.getApiKey());

        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        return response.getBody();
    }

    public Map<String, Object> sendText(int account, int conversation, String message) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", message);

        return sendMessage(account, conversation, data);
    }

    public Map<String, Object> assignTeam(int account, int conversation, int teamId) {
        Map<String, Object> toggleStatusData = new HashMap<>();
        toggleStatusData.put("status", ConversationStatus.OPEN.getName());

        Map<String, Object> assignmentData = new HashMap<>();
        assignmentData.put("team_id", teamId);

        sendRequest(account, conversation, toggleStatusData, "toggle_status");
        return sendRequest(account, conversation, assignmentData, "assignments");
    }

    public Map<String, Object> sendCard(int account, int conversation, String message,
            CardMessage cardMessage) {
        String url = String.format("%s/api/v1/accounts/%s/conversations/%s/%s", chatwootProperties.getApiUrl(), account,
                conversation, "messages");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("api_access_token", chatwootProperties.getApiKey());
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CardMessage> requestEntity = new HttpEntity<>(cardMessage, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        return response.getBody();
    }

    public Map<String, Object> sendOptions(int account, int conversation, String message,
            List<Map<String, String>> options) {

        Map<String, Object> data = new HashMap<>();

        data.put("content", message);
        data.put("content_type", "input_select");
        data.put("private", false);

        List<Map<String, String>> buttons = new ArrayList<>();

        for (Map<String, String> option : options) {
            Map<String, String> button = new HashMap<>();
            button.put("title", option.get("title"));
            button.put("value", option.get("value"));
            buttons.add(button);
        }

        Map<String, Object> contentAttributes = new HashMap<>();
        contentAttributes.put("items", buttons);

        data.put("content_attributes", contentAttributes);

        return sendMessage(account, conversation, data);
    }
}
