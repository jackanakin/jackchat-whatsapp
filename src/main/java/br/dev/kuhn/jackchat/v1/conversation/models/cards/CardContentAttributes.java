package br.dev.kuhn.jackchat.v1.conversation.models.cards;

import java.util.ArrayList;
import java.util.List;

public class CardContentAttributes {

    private List<CardItem> items;

    private CardContentAttributes(ContentAttributesBuilder builder) {
        this.items = builder.items;
    }

    public static class ContentAttributesBuilder {
        private List<CardItem> items = new ArrayList<>();

        public ContentAttributesBuilder addItem(CardItem item) {
            this.items.add(item);
            return this;
        }

        public CardContentAttributes build() {
            return new CardContentAttributes(this);
        }
    }

    public List<CardItem> getItems() {
        return items;
    }

    public void setItems(List<CardItem> items) {
        this.items = items;
    }
}
