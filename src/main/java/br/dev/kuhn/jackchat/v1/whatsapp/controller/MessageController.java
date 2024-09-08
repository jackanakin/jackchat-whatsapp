package br.dev.kuhn.jackchat.v1.whatsapp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.enums.MessageType;

public class MessageController {
    private static final Map<Integer, MessageController> controllers = Collections.synchronizedMap(new HashMap<>());

    private MessageController(PayloadDTO payload) {
        this.accountId = payload.getAccountId();
        this.conversationId = payload.getConversationId();
    }

    // Double-checked locking for thread-safe Singleton instance retrieval
    public static MessageController getInstance(PayloadDTO payload) {
        int conversationId = payload.getConversationId();
        MessageController controller = controllers.get(conversationId);

        if (controller == null) {
            synchronized (MessageController.class) { // Synchronize on the class object
                controller = controllers.get(conversationId); // Double-check
                if (controller == null) {
                    controller = new MessageController(payload);
                    controllers.put(conversationId, controller);
                }
            }
        }

        controller.add(payload);
        return controller;
    }

    private PayloadDTO lastPayload = null;
    private final Map<String, List<PayloadDTO>> payloadMap = new HashMap<>();
    private final int accountId;
    private final int conversationId;

    private synchronized void add(PayloadDTO payload) {
        String messageType = payload.getMessageType();
        List<PayloadDTO> list = payloadMap.get(messageType);

        if (list == null) {
            list = new ArrayList<>();
            payloadMap.put(messageType, list);
        }

        list.add(payload);

        this.lastPayload = payload;
    }

    public synchronized boolean isIncoming() {
        String messageType = lastPayload.getMessageType();

        return messageType.equals(MessageType.INCOMING.getName());
    }

    public synchronized int getIncomingSequence() {
        List<PayloadDTO> list = payloadMap.get(MessageType.INCOMING.getName());

        if (list == null) {
            return 0;
        }

        return list.size();
    }

    public int getAccountId() {
        return accountId;
    }

    public int getConversationId() {
        return conversationId;
    }
}