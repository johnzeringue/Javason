Javason
=======

Javason is a Java DSL that makes it easy to specify JSON directly inside of Java
source code. This provides an alternative to unreadable, difficult-to-format
strings riddled with escape characters like this:

``` java
String testPayload = "{" +
    "\"key\": \"value\"," +
    "\"with\": {" +
        "\"escapeCharacters\": true" +
    "}" +
"}";
```

Instead, Javason allows you to write the following:

``` java
String testPayload = json(
    key -> "value",
    with -> json(
        escapeCharacters -> true
    )
).toString();
```

With Javason, you're guaranteed to produce valid JSON, because Javason is Java 8
code that will be checked by the compiler. Additionally, Javason is more
readable than string literals and can be formatted by standard Java code
formatters.

Limitations
-----------

Because Javason keys are Java parameters, they are limited to being valid Java
identifiers. Additionally, because of restrictions on the Java 8 syntax, the
keys cannot conflict with any variables in scope.

Requirements
------------

Javason depends on bug fixes in Java 8u60 and cannot be used with any prior
versions of Java.

Credits
-------

Javason was inspired by [an article][] by Benji Weber.

[an article]: http://benjiweber.co.uk/blog/2015/08/17/lambda-parameter-names-with-reflection/
