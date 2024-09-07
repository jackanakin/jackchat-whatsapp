package br.dev.kuhn.jackchat.whatsapp.v1.system.version;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.kuhn.jackchat.whatsapp.v1.properties.ChatwootProperties;

@Service
public class VersionService implements IVersionService{

    @Autowired
    private ChatwootProperties chatwootProperties;

    @Override
    public String get() {
        // return "v1";
        return MessageFormat.format("v1 - ${0}", chatwootProperties.getApiUrl());
    }
    
}
