package com.demo.libapi;

/** TN — Process.waitFor on fixed argv (#124). */
public class SafeProcessWaitFor {
    public int waitFixed() throws Exception {
        Process p = new ProcessBuilder("echo", "ok").start();
        return p.waitFor();
    }
}
