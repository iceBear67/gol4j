# Gol4j

A simple logging framework for Java.

Status: Under Development.

# Features

- **Low Allocation.**    
  No objects are allocated(maybe) except for `LocalDateTime`.

- **Code First.**  
  We use code as configurations. You don't have to learn more than Java.

```java
class Example {
  static {
    var loggerFactory = LoggerFactory.create(
            LoggerConfiguration.builder()
                    .policies(List.of(
                            Policy.builder()
                                    .output(new ConsoleAppender())
                                    .prefixProvider(Prefixes.SIMPLE_PREFIX)
                                    .build(),
                            Policy.builder()
                                    .output(new SimpleFileRollingAppender("logs/logs-%d.log", 1)) // 2nd arg: roll size
                                    .minimalRequirement(LogLevel.WARN)
                                    .build()
                    ))
                    .build()
    );
  }
}
```

- **Tiny.**  
  gol4j is very tiny.

- **Java 9 Support**  
  yes we have a `module-info`

- **Warranty**  
  lmao