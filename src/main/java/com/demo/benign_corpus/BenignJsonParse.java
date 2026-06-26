package com.demo.benign_corpus;

import com.fasterxml.jackson.databind.ObjectMapper;

/** TN — JSON parse only. */
public class BenignJsonParse {
    private final ObjectMapper mapper = new ObjectMapper();
    public Object parse(String raw) throws Exception {
        return mapper.readValue(raw, Object.class);
    }
}
