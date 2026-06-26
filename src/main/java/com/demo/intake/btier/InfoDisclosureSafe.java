package com.demo.intake.btier;

import java.util.Map;

/** Safe mirror — PAT-INFO-01 */
public class InfoDisclosureSafe {
    public Map<String, String> debug(String q) {
        return Map.of("status", "ok");
    }
}
