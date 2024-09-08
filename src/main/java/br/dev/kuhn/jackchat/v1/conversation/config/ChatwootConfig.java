package br.dev.kuhn.jackchat.v1.conversation.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import br.dev.kuhn.jackchat.v1.conversation.properties.ChatwootProperties;

@Configuration
@EnableConfigurationProperties(ChatwootProperties.class)
public class ChatwootConfig {
    // Optional additional configurations
}