package pl.javastart.provider;

import pl.javastart.api.MessageProducer;

public class SimpleMessageProducer implements MessageProducer {
    private SimpleMessageProducer() { }

    @Override
    public String getMessage() {
        return "Simple Message";
    }

    public static MessageProducer provider() {
        return new SimpleMessageProducer();
    }
}
