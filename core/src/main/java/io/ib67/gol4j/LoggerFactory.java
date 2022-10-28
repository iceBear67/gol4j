package io.ib67.gol4j;

import io.ib67.gol4j.impl.LoggerFactoryImpl;
import io.ib67.gol4j.output.ConsoleAppender;
import io.ib67.gol4j.output.SimpleFileRollingAppender;
import io.ib67.gol4j.util.Prefixes;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * A factory that produces logger.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface LoggerFactory {
    static LoggerFactory getDefaultFactory() {
        if (LoggerFactoryImpl.DEFAULT_FACTORY == null) { // volatile read.
            synchronized (LoggerFactory.class) {
                if (LoggerFactoryImpl.DEFAULT_FACTORY == null) {
                    LoggerFactoryImpl.DEFAULT_FACTORY = LoggerFactory.create(
                            LoggerConfiguration.builder()
                                    .policies(List.of(
                                            Policy.builder().output(new ConsoleAppender()).prefixProvider(Prefixes.SIMPLE_PREFIX).build(),
                                            Policy.builder().output(new SimpleFileRollingAppender("logs/%d.log", 1)).build()
                                    ))
                                    .build()
                    );
                }
            }
        }
        return LoggerFactoryImpl.DEFAULT_FACTORY;
    }

    static LoggerFactory create(LoggerConfiguration configuration) {
        return new LoggerFactoryImpl(configuration);
    }

    Logger getLogger(@Nullable String name);

    Logger getAnonymousLogger();

    Map<String, Logger> getLoggers();
}
