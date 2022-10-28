package io.ib67.gol4j.output;

import io.ib67.gol4j.LoggerOutput;

public class ConsoleAppender implements LoggerOutput {
    @Override
    public LoggerOutput flush(Object message) {
        System.out.printf(String.valueOf(message));
        return this;
    }

    @Override
    public void beginLine() {

    }

    @Override
    public void endLine() {
        flush("\n");
    }
}
