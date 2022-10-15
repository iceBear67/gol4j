package io.ib67.gol4j;

import io.ib67.gol4j.output.ConsoleAppender;
import io.ib67.gol4j.process.TypeAdapter;
import io.ib67.gol4j.util.Prefixes;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;
import java.util.function.UnaryOperator;

@ApiStatus.AvailableSince("0.1.0")
@Getter
@Builder
public class LoggerConfiguration {
    @Builder.Default
    private final List<TypeAdapter<?>> typeAdapters = List.of();
    @Builder.Default
    private final UnaryOperator<Logger> postProcessor = UnaryOperator.identity();
    @Builder.Default
    private final List<Policy> policies = List.of(
            new Policy(Prefixes.SIMPLE_PREFIX, new ConsoleAppender(), LogLevel.INFO)
    );
}
