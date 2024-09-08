package br.dev.kuhn.jackchat.v1.whatsapp.handler;

import org.springframework.beans.factory.annotation.Autowired;

import br.dev.kuhn.jackchat.common.handlers.ChatbotHandler;
import br.dev.kuhn.jackchat.v1.whatsapp.rest.dto.PayloadDTO;
import br.dev.kuhn.jackchat.v1.whatsapp.service.WhatsAppService;

public abstract class WhatsAppChatbotHandler extends ChatbotHandler<WhatsAppChatbotHandler, PayloadDTO> {
    @Autowired
    protected WhatsAppService whatsAppService;
}
