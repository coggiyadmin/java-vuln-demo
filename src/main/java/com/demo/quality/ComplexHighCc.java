package com.demo.quality;

/** McCabe HIGH CC. */
public class ComplexHighCc {
    public String classify(int a, int b, int c, int d, String kind) {
        if ("x".equals(kind)) {
            if (a > 0) {
                if (b > 0) {
                    if (c > 0) return d > 0 ? "xppp" : "xppn";
                    if (c < 0) return "xpn";
                }
            } else if (a < 0) {
                return "xneg";
            }
        } else if ("y".equals(kind)) {
            return a > 0 && b > 0 ? "y1" : "y2";
        }
        return "default";
    }
}
