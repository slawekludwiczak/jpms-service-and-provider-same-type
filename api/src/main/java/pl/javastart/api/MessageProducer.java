package pl.javastart.api;

public interface MessageProducer {
    String getMessage();

    static MessageProducer provider() {
        return new SimpleMessageProducer();
    }
}
