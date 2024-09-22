package br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums;

public enum ConversationStatus {
    OPEN("open"),
    PENDING("pending"),
    RESOLVED("resolved");

    private final String name;

    ConversationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
