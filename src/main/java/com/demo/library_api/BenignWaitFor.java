package com.demo.library_api;

/** TN — Process.waitFor is not command_injection (#124). */
public class BenignWaitFor {
    public static int waitDone(Process p) throws InterruptedException {
        return p.waitFor();
    }
}
