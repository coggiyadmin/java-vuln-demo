package com.demo.interop;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.Base64;

/** IL-55 — JSON env/config blob → ObjectInputStream (IL-5 frontier). */
public class InteropEnvJsonDeser {
    public void load(String blob) throws Exception {
        JsonNode node = new ObjectMapper().readTree(blob);
        byte[] raw = Base64.getDecoder().decode(node.get("payload").asText());
        new ObjectInputStream(new ByteArrayInputStream(raw)).readObject();
    }
}
