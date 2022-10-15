package io.ib67.gol4j.process;

import io.ib67.gol4j.LogLevel;
import io.ib67.gol4j.LoggerOutput;

public interface PrefixProvider {

    void accept(LoggerOutput out, LogLevel lvl, String name);
}
