package br.dev.kuhn.jackchat.whatsapp.v1.system.echo;

import org.springframework.stereotype.Service;

@Service
public class EchoService implements IEchoService {

    @Override
    public String echo(String string) {
        return string;
    }
    
}
