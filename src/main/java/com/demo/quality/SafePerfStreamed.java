package com.demo.quality;

import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

/** SAFE mirror — streamed lines from fixed allowlisted log files only. */
public class SafePerfStreamed {
    private static final Path ACCESS_LOG = Path.of("/var/log/app/access.log");
    private static final Path ERROR_LOG = Path.of("/var/log/app/error.log");

    public Stream<String> processLog(String logKind) throws IOException {
        Path target = switch (logKind) {
            case "access" -> ACCESS_LOG;
            case "error" -> ERROR_LOG;
            default -> throw new SecurityException("invalid log kind");
        };
        return Files.lines(target).limit(1000);
    }
}
