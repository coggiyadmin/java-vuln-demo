package com.demo.quality;
/** Low MI — monolithic decision tree. */
public class LowMi {
    public int orchestrate(int a, int b, int c, int d, int e, int f, int g, int h) {
        int acc = 0;
        if (a > 0 && b > 0) {
            if (c > 0 || d > 0) {
                for (int i = 0; i < f; i++) {
                    if (i % 2 == 0 && g > 0) acc += i * h;
                    else if (i % 3 == 0 && e > 0) acc -= i + e;
                    else acc ^= g + h;
                }
            } else if (e > 0 && f > 0) {
                acc = a + b + c + d + e + f;
            }
        }
        return acc + a + b + c;
    }
}
