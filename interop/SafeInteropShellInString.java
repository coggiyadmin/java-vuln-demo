package com.demo.interop;

/** SAFE mirror — fixed argv, no shell interpolation. */
public class SafeInteropShellInString {
    public void run(String arg) throws Exception {
        Runtime.getRuntime().exec(new String[]{"echo", "--", arg});
    }
}
