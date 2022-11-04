branches:
- api-and-provider-in-single-module
- api-and-provider-in-single-module-metainf

shows the case when the service and provider is same type `MessageProducer`.

`Service provider` is provided by `provider method` as follows:

```
public interface MessageProducer {
    String getMessage();

    static MessageProducer provider() {
        return new SimpleMessageProducer();
    }
}
```

When provider is declared in module-info.java:

```
module api {
    exports pl.javastart.api;
    provides pl.javastart.api.MessageProducer with pl.javastart.api.MessageProducer;
}
```

Obtaining the provider works fine:

```
ServiceLoader<MessageProducer> loader = ServiceLoader.load(MessageProducer.class);
MessageProducer messageProducer = loader.findFirst().orElseThrow(); //ok
```

But when the `META-INF/services/pl.javastart.api.MessageProducer` is used instead of `module-info.java`,
then provider is not resolved and the exception is thrown
`Caused by: java.lang.NoSuchMethodException: pl.javastart.api.MessageProducer.<init>()`

The [ServiceLoader](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/ServiceLoader.html) docs is inconsistent and it states:
> A service provider (or just provider) is a **class** that implements or subclasses the well-known interface or class.

but then in [Developing service providers](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/ServiceLoader.html#developing-service-providers) section there is:
> A service provider is a single **type**, usually a concrete class. An **interface or abstract class is permitted** because it may declare a static provider method, discussed later.



