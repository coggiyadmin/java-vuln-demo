// FP-target (upstream cognium-dev#124) — Process.waitFor() blocks for completion; it executes
// nothing and must not be flagged command_injection.
package com.demo.libapi;

public class SafeProcessWaitFor {
    public int await(Process p) throws InterruptedException {
        return p.waitFor(); // NOT a sink
    }
}
