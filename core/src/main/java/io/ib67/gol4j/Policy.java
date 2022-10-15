package io.ib67.gol4j;

import io.ib67.gol4j.process.PrefixProvider;
import lombok.Builder;

public record Policy(
        PrefixProvider prefixProvider,
        LoggerOutput output,
        LogLevel minimalRequirement
) {
    @Builder
    public Policy {

    }
}
