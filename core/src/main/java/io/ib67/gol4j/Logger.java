package io.ib67.gol4j;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/**
 * An abstract logger with some logging actions defined.
 * <p>
 * Usages like <code>Info: {}, info</code> are unsupported. Please use <code>"Info:", info</code> instead
 */
@SuppressWarnings("unused")
@ApiStatus.AvailableSince("0.1.0")
public interface Logger {
    /**
     * Log messages with a {@link LogLevel}
     *
     * @param lvl  level
     * @param args messages
     */
    void $atLevel(LogLevel lvl, boolean combineWithSpace, Object... args);

    @Nullable
    String getName();

    default void info(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.INFO, combineWithSpace, args);
    }

    default void info(Object... args) {
        $atLevel(LogLevel.INFO, true, args);
    }

    default void warn(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.WARN, combineWithSpace, args);
    }

    default void warn(Object... args) {
        $atLevel(LogLevel.WARN, true, args);
    }

    default void error(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.ERROR, combineWithSpace, args);
    }

    default void error(Object... args) {
        $atLevel(LogLevel.ERROR, true, args);
    }

    default void fatal(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.FATAL, combineWithSpace, args);
    }

    default void fatal(Object... args) {
        $atLevel(LogLevel.FATAL, true, args);
    }

    default void verbose(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.VERBOSE, combineWithSpace, args);
    }

    default void verbose(Object... args) {
        $atLevel(LogLevel.VERBOSE, true, args);
    }

    default void debug(boolean combineWithSpace, Object... args) {
        $atLevel(LogLevel.DEBUG, combineWithSpace, args);
    }

    default void debug(Object... args) {
        $atLevel(LogLevel.DEBUG, true, args);
    }

}
