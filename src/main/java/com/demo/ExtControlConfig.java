package com.demo;

import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-15 External Control of System or Configuration Setting.
 * A user-controlled key/value writes directly into JVM system properties.
 */
public class ExtControlConfig {

    public void config(HttpServletRequest request) {
        String key = request.getParameter("k");   // SOURCE — attacker-controlled setting
        String val = request.getParameter("v");
        System.setProperty(key, val);             // user controls arbitrary config → CWE-15
    }
}
