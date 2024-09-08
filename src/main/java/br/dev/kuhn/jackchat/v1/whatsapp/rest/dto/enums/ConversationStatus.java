package br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.enums;

public enum ConversationStatus {
    RESOLVED("resolved");

    private final String name;

    ConversationStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
