package br.dev.kuhn.jackchat.v1.conversation.models.cards;

public class CardAction {

    private String type;
    private String text;
    private String uri;
    private String payload;

    private CardAction(ActionBuilder builder) {
        this.type = builder.type;
        this.text = builder.text;
        this.uri = builder.uri;
        this.payload = builder.payload;
    }

    public static class ActionBuilder {
        private String type;
        private String text;
        private String uri;
        private String payload;

        public ActionBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public ActionBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public ActionBuilder setUri(String uri) {
            this.uri = uri;
            return this;
        }

        public ActionBuilder setPayload(String payload) {
            this.payload = payload;
            return this;
        }

        public CardAction build() {
            return new CardAction(this);
        }
    }

    public String getPayload() {
        return payload;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}