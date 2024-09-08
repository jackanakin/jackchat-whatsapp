package br.dev.kuhn.jackchat.common.handlers;

public abstract class ChatbotHandler<P, I> {
    protected P nextHandler;

    public P handle(I input) {
        return handleImplementation(input);
    }

    protected abstract P handleImplementation(I input);
}
