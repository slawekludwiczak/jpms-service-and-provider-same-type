package pl.javastart.api;

class SimpleMessageProducer implements MessageProducer {
    @Override
    public String getMessage() {
        return "Simple Message";
    }

}
