package io.ib67.gol4j.process;

import io.ib67.gol4j.impl.TypeAdapterImpl;

import java.util.function.Function;

public interface TypeAdapter<T> {
    TypeAdapter<?> EMPTY = of(null, String::valueOf);

    static <T> TypeAdapter<T> of(Class<T> type, Function<T, String> mapper) {
        return new TypeAdapterImpl<>(type, mapper);
    }

    Class<T> getSourceType();

    String map(Object t);
}
