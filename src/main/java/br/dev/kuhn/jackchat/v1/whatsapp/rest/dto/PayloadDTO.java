package br.dev.kuhn.jackchat.v1.whatsapp.rest.dto;

public class PayloadDTO {
    private final int conversationId;
    private final int accountId;
    private final String event;

    private String content = "";
    private String messageType = "";

    public PayloadDTO(String event, int conversationId, int accountId) {
        this.event = event;
        this.conversationId = conversationId;
        this.accountId = accountId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        if (messageType != null) {
            this.messageType = messageType;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content != null) {
            this.content = content;
        }
    }

    public String getEvent() {
        return event;
    }

    public int getConversationId() {
        return conversationId;
    }

    public int getAccountId() {
        return accountId;
    }
}
