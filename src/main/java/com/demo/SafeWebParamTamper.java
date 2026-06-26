package com.demo;

import java.util.Map;

/** SAFE mirror — WebParamTamper. Price from server catalog, not client field. */
public class SafeWebParamTamper {
    private static final Map<String, Double> CATALOG = Map.of("sku-1", 9.99);

    public double checkout(String sku, int qty) {
        return CATALOG.get(sku) * qty;
    }
}
