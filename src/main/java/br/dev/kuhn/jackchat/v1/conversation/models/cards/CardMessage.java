package br.dev.kuhn.jackchat.v1.conversation.models.cards;

public class CardMessage {

    private String content;
    private String content_type = "cards";
    private CardContentAttributes content_attributes;

    private CardMessage(CardMessageBuilder builder) {
        this.content = builder.content;
        this.content_attributes = builder.contentAttributes;
    }

    public static class CardMessageBuilder {
        private String content;
        private CardContentAttributes contentAttributes;

        public CardMessageBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public CardMessageBuilder setContentAttributes(CardContentAttributes contentAttributes) {
            this.contentAttributes = contentAttributes;
            return this;
        }

        public CardMessage build() {
            return new CardMessage(this);
        }
    }

    public String getContent() {
        return content;
    }

    public CardContentAttributes getContent_attributes() {
        return content_attributes;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setContent_attributes(CardContentAttributes content_attributes) {
        this.content_attributes = content_attributes;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }
}