// TN — benign read-only lookup; fixed catalog by exact key.
package com.demo.aisec;

import java.util.Map;

public class BenignReadonlyLookup {
    private static final Map<String, String> CATALOG = Map.of(
        "USD", "US Dollar", "EUR", "Euro", "JPY", "Japanese Yen");
    public String currencyName(String code) {
        return CATALOG.getOrDefault(code.toUpperCase(), "unknown");
    }
}
