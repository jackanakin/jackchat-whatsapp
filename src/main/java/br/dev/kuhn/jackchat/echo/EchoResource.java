package br.dev.kuhn.jackchat.echo;

import org.springframework.web.bind.annotation.RestController;

import br.dev.kuhn.jackchat.common.CommonResource;

@RestController
public class EchoResource implements IEchoResource, CommonResource {

    @Override
    public String get() {
        return "echo";
    }

    @Override
    public String post(String string) {
        return string;
    }

}
