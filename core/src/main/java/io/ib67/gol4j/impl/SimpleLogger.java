package io.ib67.gol4j.impl;

import io.ib67.gol4j.LogLevel;
import io.ib67.gol4j.Logger;
import io.ib67.gol4j.Policy;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@RequiredArgsConstructor
public class SimpleLogger implements Logger {

    private final String name;
    private final List<Policy> policies;

    @Override
    public void $atLevel(LogLevel lvl, boolean combineWithSpace, Object... args) {
        for (Policy policy : policies) {
            if (lvl.ordinal() > policy.minimalRequirement().ordinal()) continue;
            if (policy.prefixProvider() != null) policy.prefixProvider().accept(policy.output(), lvl, name);
            var output = policy.output();
            for (Object arg : args) {
                output.flush(String.valueOf(arg));
            }
            output.flush("\n");
        }
    }


    @Override
    public @Nullable String getName() {
        return name;
    }
}
