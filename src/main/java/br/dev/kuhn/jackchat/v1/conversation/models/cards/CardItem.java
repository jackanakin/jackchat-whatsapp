package br.dev.kuhn.jackchat.v1.conversation.models.cards;

import java.util.ArrayList;
import java.util.List;

public class CardItem {

    private String media_url;
    private String title;
    private String description;
    private List<CardAction> actions;

    private CardItem(ItemBuilder builder) {
        this.media_url = builder.mediaUrl;
        this.title = builder.title;
        this.description = builder.description;
        this.actions = builder.actions;
    }

    public static class ItemBuilder {
        private String mediaUrl;
        private String title;
        private String description;
        private List<CardAction> actions = new ArrayList<>();

        public ItemBuilder setMediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        public ItemBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ItemBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ItemBuilder addAction(CardAction action) {
            this.actions.add(action);
            return this;
        }

        public CardItem build() {
            return new CardItem(this);
        }
    }

    public List<CardAction> getActions() {
        return actions;
    }

    public String getDescription() {
        return description;
    }

    public String getMedia_url() {
        return media_url;
    }

    public String getTitle() {
        return title;
    }

    public void setActions(List<CardAction> actions) {
        this.actions = actions;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
