package br.dev.kuhn.jackchat.v1.whatsapp.rest.dto;

import java.util.Map;

import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.converters.ConversationResolvedConverter;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.converters.MessageCreatedConverter;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.enums.PayloadEvent;

public class WhatsAppRequestFactory {
    public static PayloadDTO create(Map<String, Object> json) {
        String event = (String) json.get("event");

        if (event.equals(PayloadEvent.CONVERSATION_RESOLVED.getName())) {
            return ConversationResolvedConverter.convert(json);
        } else if (event.equals(PayloadEvent.MESSAGE_CREATED.getName())) {
            return MessageCreatedConverter.convert(json);
        }

        return null;
    }
}
