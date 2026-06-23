package com.demo.quality;

import java.nio.file.*;

/** Performance anti-pattern. */
public class PerfBlockingAlloc {
    public byte[] processLog(String path) throws Exception {
        return Files.readAllBytes(Path.of(path));
    }
}
