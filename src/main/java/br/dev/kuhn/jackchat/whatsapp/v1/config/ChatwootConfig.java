package br.dev.kuhn.jackchat.whatsapp.v1.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import br.dev.kuhn.jackchat.whatsapp.v1.properties.ChatwootProperties;

@Configuration
@EnableConfigurationProperties(ChatwootProperties.class)
public class ChatwootConfig {
    // Optional additional configurations
}