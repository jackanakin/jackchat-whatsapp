package br.dev.kuhn.jackchat.v1.conversation.rest.dto.enums;

public enum MessageType {
    INCOMING("incoming"),
    OUTGOING("outgoing"),
    ACTIVITY("activity"),
    TEMPLATE("template");

    private final String name;

    MessageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
