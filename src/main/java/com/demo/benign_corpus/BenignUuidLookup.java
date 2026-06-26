package com.demo.benign_corpus;

import java.util.UUID;

/** TN — UUID validation before lookup. */
public class BenignUuidLookup {
    public UUID parseId(String raw) {
        return UUID.fromString(raw);
    }
}
