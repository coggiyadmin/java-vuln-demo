package com.demo.quality;
public class SafeLowMi {
    private static int even(int i, int g, int h) { return (i % 2 == 0 && g > 0) ? i * h : 0; }
    private static int odd(int i, int e, int g, int h) {
        if (i % 3 == 0 && e > 0) return -(i + e);
        return g ^ h;
    }
    public int orchestrate(int a, int b, int c, int d, int e, int f, int g, int h) {
        int acc = 0;
        if (a > 0 && b > 0 && c > 0 && (d > 0 || e > 0)) {
            for (int i = 0; i < f; i++) {
                int v = even(i, g, h);
                if (v == 0) v = odd(i, e, g, h);
                acc += v;
            }
        } else if (e > 0 && f > 0) {
            acc = a + b + c + d + e + f;
        }
        return acc + a + b + c;
    }
}
