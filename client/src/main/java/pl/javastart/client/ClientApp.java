package pl.javastart.client;

import pl.javastart.api.MessageProducer;

import java.util.ServiceLoader;

class ClientApp {
    public static void main(String[] args) {
        ServiceLoader<MessageProducer> loader = ServiceLoader.load(MessageProducer.class);
        MessageProducer messageProducer = loader.findFirst().orElseThrow();
        System.out.println(messageProducer.getMessage());
    }
}
