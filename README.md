# Gol4j

A simple logging framework for Java.

Status: Under Development.

# Features

- **Low Allocation.**    
  No objects are allocated except for `LocalDateTime`.

- **Code First.**  
  We use code as configurations. You don't have to learn another format again.

```java
    var consoleOnly=LoggerFactory.create(
        LoggerConfiguration.builder().build()
        );
        var general=LoggerFactory.create(
        LoggerConfiguration.builder()
        .policies(List.of(
        new Policy(Prefixes.SIMPLE_PREFIX,new ConsoleAppender(),LogLevel.INFO),
        new Policy(Prefixes.SIMPLE_PREFIX,new SimpleFileRollingAppender("logs/logs-%d.log",2),LogLevel.INFO)
        ))
        .build()
        );
```

- **Tiny.**  
  gol4j is small.

- **Warranty**  
  lmao

# Some meaningless screenshots

![](https://upload.cc/i1/2022/10/15/fTCSFq.png)