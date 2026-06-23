package com.demo.quality;

import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

/** SAFE mirror — streamed lines from fixed log dir with bounded id. */
public class SafePerfStreamed {
    private static final Path LOG_DIR = Path.of("/var/log/app");

    public Stream<String> processLog(String logId) throws IOException {
        if (!logId.matches("[a-z0-9_-]+")) throw new SecurityException("invalid id");
        return Files.lines(LOG_DIR.resolve(logId + ".log")).limit(1000);
    }
}
