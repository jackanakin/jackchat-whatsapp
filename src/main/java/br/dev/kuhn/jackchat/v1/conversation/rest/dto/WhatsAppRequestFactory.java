package br.dev.kuhn.jackchat.v1.conversation.rest.dto;

import java.util.Map;

import br.dev.kuhn.jackchat.v1.conversation.rest.dto.converters.ConversationOpenedConverter;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.converters.ConversationResolvedConverter;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.converters.MessageCreatedConverter;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums.PayloadEvent;

public class WhatsAppRequestFactory {
    public static PayloadDTO create(Map<String, Object> json) {
        String event = (String) json.get("event");

        if (event.equals(PayloadEvent.CONVERSATION_RESOLVED.getName())) {
            return ConversationResolvedConverter.convert(json);
        } else if (event.equals(PayloadEvent.MESSAGE_CREATED.getName())) {
            return MessageCreatedConverter.convert(json);
        } else if (event.equals(PayloadEvent.CONVERSATION_OPENED.getName())) {
            return ConversationOpenedConverter.convert(json);
        }

        return null;
    }
}
