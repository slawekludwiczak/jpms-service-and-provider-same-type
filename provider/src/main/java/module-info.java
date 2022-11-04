import pl.javastart.provider.SimpleMessageProducer;

module provider {
    requires api;
    provides pl.javastart.api.MessageProducer with SimpleMessageProducer;
}
