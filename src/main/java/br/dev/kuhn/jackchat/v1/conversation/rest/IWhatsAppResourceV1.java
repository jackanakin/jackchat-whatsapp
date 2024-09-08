package br.dev.kuhn.jackchat.v1.conversation.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.dev.kuhn.jackchat.common.CommonResource;

@RequestMapping("/v1/whatsapp")
public interface IWhatsAppResourceV1 extends CommonResource {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Boolean> post(@RequestBody Map<String, Object> data);
}
