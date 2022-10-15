package io.ib67.gol4j.impl;

import io.ib67.gol4j.process.TypeAdapter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class TypeAdapterImpl<T> implements TypeAdapter<T> {
    private final Class<T> type;
    private final Function<T, String> mapper;

    @Override
    public Class<T> getSourceType() {
        return type;
    }

    @Override
    public String map(Object t) {
        return mapper.apply((T) t);
    }
}
