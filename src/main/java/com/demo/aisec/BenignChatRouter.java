// TN — benign chat router; routes by typed key, no untrusted text reaches a prompt.
package com.demo.aisec;

import java.util.Map;
import java.util.function.Supplier;

public class BenignChatRouter {
    private static final Map<String, Supplier<String>> HANDLERS = Map.of(
        "billing", () -> "Routing to billing.", "support", () -> "Routing to support.");

    public String route(String intent) {
        return HANDLERS.getOrDefault(intent, () -> "unknown").get();
    }
}
