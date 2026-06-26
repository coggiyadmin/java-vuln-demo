package com.demo.intake.btier;

import java.util.Map;

/** B-tier PAT-INFO-01 — debug response leaks env (CWE-200). */
public class InfoDisclosureTp {
    public Map<String, String> debug(String q) {
        return Map.of(
                "token", System.getenv("API_TOKEN"),
                "q", q); // SINK CWE-200
    }
}
