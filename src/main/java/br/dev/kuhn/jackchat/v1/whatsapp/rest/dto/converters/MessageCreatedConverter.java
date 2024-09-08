package br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.converters;

import java.util.Map;

import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.enums.PayloadEvent;

public class MessageCreatedConverter {
    public static PayloadDTO convert(Map<String, Object> json) {
        int accountId = parseAccountId(json);
        int conversationId = parseConversationId(json);

        String content = (String) json.get("content");
        String messageType = (String) json.get("message_type");

        PayloadDTO payload = new PayloadDTO(PayloadEvent.MESSAGE_CREATED.getName(), conversationId, accountId);
        payload.setContent(content);
        payload.setMessageType(messageType);

        return payload;
    }

    public static int parseConversationId(Map<String, Object> json) {
        int conversationId = 0;

        Map<String, Object> conversationData = (Map<String, Object>) json.get("conversation");

        if (conversationData != null) {
            Object object = conversationData.get("id");

            if (object instanceof Integer integer) {
                conversationId = integer;
            }
        }

        return conversationId;
    }

    public static int parseAccountId(Map<String, Object> json) {
        int accountId = 0;

        Map<String, Object> accountData = (Map<String, Object>) json.get("account");

        if (accountData != null) {
            Object object = accountData.get("id");

            if (object instanceof Integer integer) {

                accountId = integer;
            }
        }

        return accountId;
    }
}
