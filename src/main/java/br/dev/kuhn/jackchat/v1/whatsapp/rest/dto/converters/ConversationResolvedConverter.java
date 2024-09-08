package br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.converters;

import java.util.Map;

import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.enums.PayloadEvent;

public class ConversationResolvedConverter {
    public static PayloadDTO convert(Map<String, Object> json) {
        return new PayloadDTO(PayloadEvent.CONVERSATION_RESOLVED.getName(), (Integer) json.get("id"), 0);
    }
}
