package br.dev.kuhn.jackchat.v1.conversation.handler;

import org.springframework.beans.factory.annotation.Autowired;

import br.dev.kuhn.jackchat.common.handlers.ChatbotHandler;
import br.dev.kuhn.jackchat.v1.conversation.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.conversation.service.ConversationService;

public abstract class WhatsAppChatbotHandler extends ChatbotHandler<WhatsAppChatbotHandler, PayloadDTO> {
    @Autowired
    protected ConversationService whatsAppService;
}
