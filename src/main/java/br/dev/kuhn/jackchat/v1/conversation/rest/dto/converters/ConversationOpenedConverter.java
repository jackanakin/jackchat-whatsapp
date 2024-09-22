package br.dev.kuhn.jackchat.v1.conversation.rest.dto.converters;

import java.util.Map;

import br.dev.kuhn.jackchat.v1.conversation.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums.PayloadEvent;

public class ConversationOpenedConverter {
    public static PayloadDTO convert(Map<String, Object> json) {
        // Map<String, Object> contactInbox = (Map<String, Object>) json.get("contact_inbox");

        // Integer contactId = (Integer) contactInbox.get("contact_id");

        return new PayloadDTO(PayloadEvent.CONVERSATION_OPENED.getName(), (Integer) json.get("id"), 0);
    }
}
