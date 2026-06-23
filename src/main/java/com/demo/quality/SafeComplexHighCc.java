package com.demo.quality;

/** SAFE mirror — low CC. */
public class SafeComplexHighCc {
    public String classify(int a, int b, String kind) {
        if ("x".equals(kind)) return a > 0 ? "xp" : "xn";
        if ("y".equals(kind)) return a > 0 && b > 0 ? "y_ok" : "y_alt";
        return "default";
    }
}
