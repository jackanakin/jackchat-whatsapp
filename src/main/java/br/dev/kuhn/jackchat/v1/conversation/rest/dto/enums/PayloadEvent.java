package br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums;

public enum PayloadEvent {
    CONVERSATION_RESOLVED("conversation_resolved"),
    CONVERSATION_OPENED("conversation_opened"),
    MESSAGE_CREATED("message_created");

    private final String name;

    PayloadEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
