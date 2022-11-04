package pl.javastart.api;

public interface MessageProducer {
    String getMessage();

    public static MessageProducer provider() {
        return new SimpleMessageProducer();
    }
}
