package com.demo;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — ExtControlConfig.java; only allow-listed settings may be changed.
 */
public class SafeExtControlConfig {

    private static final Set<String> ALLOWED = Set.of("locale", "theme");

    public void config(HttpServletRequest request) {
        String key = request.getParameter("k");
        if (!ALLOWED.contains(key)) {             // allow-listed keys only
            throw new IllegalArgumentException("forbidden key");
        }
        System.setProperty("app." + key, request.getParameter("v"));
    }
}
