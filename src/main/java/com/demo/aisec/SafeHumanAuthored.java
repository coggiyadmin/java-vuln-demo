package com.demo.aisec;

/** SAFE mirror. */
public class SafeHumanAuthored {
    public int sumPositive(int[] values) {
        int sum = 0;
        for (int v : values) if (v > 0) sum += v;
        return sum;
    }
}
