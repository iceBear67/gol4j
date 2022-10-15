package io.ib67.gol4j;

import io.ib67.gol4j.impl.LoggerFactoryImpl;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * A factory that produces logger.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface LoggerFactory {
    LoggerFactory inMemory = create(
            LoggerConfiguration.builder().build()
    );

    static LoggerFactory create(LoggerConfiguration configuration) {
        return new LoggerFactoryImpl(configuration);
    }

    Logger getLogger(@Nullable String name);

    Logger getAnonymousLogger();

    Map<String, Logger> getLoggers();
}
