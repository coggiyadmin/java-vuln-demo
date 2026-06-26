package com.demo.benign_corpus;

import java.nio.file.*;

/** TN — normalize under root. */
public class BenignPathNormalize {
    private static final Path ROOT = Paths.get("/data");
    public Path safe(String name) throws Exception {
        Path full = ROOT.resolve(name).normalize();
        if (!full.startsWith(ROOT)) throw new SecurityException("escape");
        return full;
    }
}
