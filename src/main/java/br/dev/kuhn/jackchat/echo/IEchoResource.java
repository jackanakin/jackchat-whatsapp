package br.dev.kuhn.jackchat.echo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/echo")
public interface IEchoResource {
    @GetMapping
    String get();

    @PostMapping
    String post(String string);
}
