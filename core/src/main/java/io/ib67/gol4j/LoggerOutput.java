package io.ib67.gol4j;

import org.jetbrains.annotations.ApiStatus;

/**
 * A destination to print messages, can be files or stdout.<br/>
 * <p>
 * LoggeOutputs are thread-safe.
 */
@ApiStatus.AvailableSince("0.1.0")
public interface LoggerOutput {
    LoggerOutput flush(Object message);

    // for some large overhead outputs. (such as IO related)
    void beginLine();

    void endLine();
}
