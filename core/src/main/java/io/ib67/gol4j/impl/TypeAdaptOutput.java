package io.ib67.gol4j.impl;

import io.ib67.gol4j.LoggerOutput;
import io.ib67.gol4j.process.TypeAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TypeAdaptOutput implements LoggerOutput {

    private final LoggerOutput next;
    private final List<TypeAdapter<?>> adapters;

    @Override
    public LoggerOutput flush(Object message) {
        var msg = adapters.stream()
                .filter(it -> it.getSourceType().isAssignableFrom(message.getClass()))
                .findFirst().orElse(TypeAdapter.EMPTY)
                .map(message);
        next.flush(msg);
        return this;
    }

    @Override
    public void beginLine() {
        next.beginLine();
    }

    @Override
    public void endLine() {
        next.endLine();
    }
}
