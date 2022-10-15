package io.ib67.gol4j;

import org.jetbrains.annotations.ApiStatus;

/**
 * Log Levels.
 */
@ApiStatus.AvailableSince("0.1.0")
public enum LogLevel {
    /**
     * Some exceptions that we can't handle
     */
    FATAL,
    /**
     * Some serious exceptions we can try to handle it
     */
    ERROR,
    /**
     * Some exceptions we can handle it well
     */
    WARN,
    /**
     * Normal messages
     */
    INFO,
    /**
     * For more detailed information
     */
    VERBOSE,
    /**
     * For debugging
     */
    DEBUG
}
