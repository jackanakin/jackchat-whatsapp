package br.dev.kuhn.jackchat.v1.conversation.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.dev.kuhn.jackchat.v1.conversation.properties.ChatwootProperties;

@Service
public class ConversationService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatwootProperties chatwootProperties;

    // Common method to send API requests to Chatwoot
    private Map<String, Object> sendRequest(int account, int conversation, Map<String, Object> data,
            String endpoint) {
        String url = String.format("%s/api/v1/accounts/%s/conversations/%s/%s", chatwootProperties.getApiUrl(), account,
                conversation, endpoint);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");
        headers.set("api_access_token", chatwootProperties.getApiKey());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(data, headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, request, Map.class);

        return response.getBody();
    }

    // Method to send a text message
    public Map<String, Object> sendText(int account, int conversation, String message) {
        Map<String, Object> data = new HashMap<>();
        data.put("content", message);

        return sendRequest(account, conversation, data, "messages");
    }

    // Method to send a handoff action
    public Map<String, Object> sendHandoff(int account, int conversation) {
        Map<String, Object> data = new HashMap<>();
        data.put("action", "handoff");

        return sendRequest(account, conversation, data, "assignments");
    }
}
