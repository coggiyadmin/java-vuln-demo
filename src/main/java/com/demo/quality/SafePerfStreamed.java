package com.demo.quality;

import java.nio.file.*;
import java.util.stream.*;
import java.io.*;

/** SAFE mirror — streamed lines. */
public class SafePerfStreamed {
    public Stream<String> processLog(String path) throws IOException {
        return Files.lines(Path.of(path)).limit(1000);
    }
}
