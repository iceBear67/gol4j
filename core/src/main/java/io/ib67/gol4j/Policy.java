package io.ib67.gol4j;

import io.ib67.gol4j.process.PrefixProvider;
import lombok.Builder;

import java.util.Objects;

public record Policy(
        PrefixProvider prefixProvider,
        LoggerOutput output,
        LogLevel minimalRequirement
) {
    @Builder
    public Policy {
        Objects.requireNonNull(output, "Log destination cannot be null");
        if (minimalRequirement == null) {
            minimalRequirement = LogLevel.INFO;
        }
    }
}
