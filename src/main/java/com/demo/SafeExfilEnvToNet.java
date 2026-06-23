package com.demo;

import java.net.*;
import java.io.*;

/** SAFE mirror — key used as auth header only; static non-sensitive payload. */
public class SafeExfilEnvToNet {
    private static final byte[] STATIC_METRICS = "{\"event\":\"heartbeat\"}".getBytes();

    public void reportMetrics() throws IOException {
        String apiKey = System.getenv("INTERNAL_API_KEY");
        HttpURLConnection conn = (HttpURLConnection) new URL(
            "https://api.internal.example.com/metrics").openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setDoOutput(true);
        conn.getOutputStream().write(STATIC_METRICS);
    }
}
