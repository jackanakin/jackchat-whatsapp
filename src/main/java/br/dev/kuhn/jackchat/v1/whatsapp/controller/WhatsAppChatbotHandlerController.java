package br.dev.kuhn.jackchat.v1.whatsapp.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.dev.kuhn.jackchat.v1.whatsapp.handler.WhatsAppChatbotHandler;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.PayloadDTO;

public class WhatsAppChatbotHandlerController {
    private static final Map<Integer, WhatsAppChatbotHandlerController> controllers = Collections
            .synchronizedMap(new HashMap<>());

    private WhatsAppChatbotHandlerController() {
    }

    public static WhatsAppChatbotHandlerController getInstance(int conversationId) {
        WhatsAppChatbotHandlerController controller = controllers.get(conversationId);

        if (controller == null) {
            synchronized (WhatsAppChatbotHandlerController.class) { // Synchronize on the class object
                controller = controllers.get(conversationId); // Double-check
                if (controller == null) {
                    controller = new WhatsAppChatbotHandlerController();
                    controllers.put(conversationId, controller);
                }
            }
        }

        return controller;
    }

    public static void removeController(int conversationId) {
        synchronized (WhatsAppChatbotHandlerController.class) {
            controllers.remove(conversationId);
        }
    }

    private WhatsAppChatbotHandler handler;
    private boolean isFinished = false;

    public boolean isNotStarted() {
        return handler == null;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void handle(PayloadDTO input) {
        if (handler != null) {
            this.handler = handler.handle(input);

            if (handler == null) {
                this.isFinished = true;
            }
        }
    }

    public void setInitialHandler(WhatsAppChatbotHandler handler) {
        this.handler = handler;
    }
}