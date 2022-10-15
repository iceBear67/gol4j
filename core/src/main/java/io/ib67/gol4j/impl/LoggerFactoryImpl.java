package io.ib67.gol4j.impl;

import io.ib67.gol4j.Logger;
import io.ib67.gol4j.LoggerConfiguration;
import io.ib67.gol4j.LoggerFactory;
import io.ib67.gol4j.Policy;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoggerFactoryImpl implements LoggerFactory {
    private final LoggerConfiguration config;
    private final Logger anonymousLogger;

    private final Map<String, Logger> loggers = new ConcurrentHashMap<>();

    public LoggerFactoryImpl(LoggerConfiguration configuration) {
        this.config = configuration;
        anonymousLogger = createLogger(null);
    }

    @Override
    public Logger getLogger(@Nullable String name) {
        return loggers.computeIfAbsent(name, this::createLogger);
    }

    private Logger createLogger(String s) {
        return config.getPostProcessor().apply(new SimpleLogger(s,
                config.getPolicies().stream()
                        .map(it ->
                                new Policy(it.prefixProvider(), new TypeAdaptOutput(it.output(), config.getTypeAdapters()), it.minimalRequirement())
                        ).toList()
        ));
    }

    @Override
    public Logger getAnonymousLogger() {
        return anonymousLogger;
    }

    @Override
    public Map<String, Logger> getLoggers() {
        return loggers;
    }
}
