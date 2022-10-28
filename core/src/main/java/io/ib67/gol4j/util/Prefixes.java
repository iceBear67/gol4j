package io.ib67.gol4j.util;

import asia.kala.ansi.AnsiString;
import io.ib67.gol4j.LogLevel;
import io.ib67.gol4j.process.PrefixProvider;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EnumMap;
import java.util.Map;

@UtilityClass
public class Prefixes {
    public static final PrefixProvider SIMPLE_PREFIX;
    public static final PrefixProvider FILE_PREFIX;
    private static final Map<LogLevel, String> PREFIXES = new EnumMap<>(LogLevel.class);

    static {
        PREFIXES.put(LogLevel.DEBUG, AnsiString.valueOf("DEBG").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Back.Magenta,
                        AnsiString.Color.White
                )).toString());
        PREFIXES.put(LogLevel.ERROR, AnsiString.valueOf("ERROR").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Back.LightRed,
                        AnsiString.Color.White
                )
        ).toString());
        PREFIXES.put(LogLevel.FATAL, AnsiString.valueOf("FATAL").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Back.Red,
                        AnsiString.Color.White
                )
        ).toString());
        PREFIXES.put(LogLevel.INFO, AnsiString.valueOf("INFO").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Back.LightBlue,
                        AnsiString.Color.White
                )
        ).toString());
        PREFIXES.put(LogLevel.WARN, AnsiString.valueOf("WARN").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Back.LightYellow,
                        AnsiString.Color.White
                )
        ).toString());
        PREFIXES.put(LogLevel.VERBOSE, AnsiString.valueOf("VERBOSE").overlay(
                AnsiString.Attribute.of(
                        AnsiString.Color.LightGray
                )
        ).toString());
        SIMPLE_PREFIX = (out, lvl, name) -> {
            var a = out.flush(LocalDateTime.now().format(DateTimeUtil.FMT))
                    .flush(" ").flush(PREFIXES.get(lvl)).flush(" ");
            if (name != null) {
                a.flush(renderName(name)).flush(" ");
            }
            a.flush("- ");
        };
        FILE_PREFIX = (out, lvl, name) -> {
            var a = out.flush(LocalDateTime.now().format(DateTimeFormatter.ISO_TIME)).flush(" [").flush(Thread.currentThread().getName())
                    .flush("/").flush(lvl).flush("]").flush(" ").flush(name == null ? "" : name).flush(": ");
        };
    }

    private static String renderName(String name) {
        return AnsiString.valueOf(name).overlay(
                AnsiString.Attribute.of(AnsiString.Color.Blue)
        ).toString();
    }

}
