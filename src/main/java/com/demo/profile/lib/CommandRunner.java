// FP-target (#128/#169) — LIBRARY profile. Public utility; `cmd` is caller-supplied, not an
// entry point. Must not be command_injection under an entry-point gate.
package com.demo.profile.lib;

public final class CommandRunner {
    private CommandRunner() {}
    public static Process run(String cmd) throws Exception {
        return Runtime.getRuntime().exec(cmd); // caller-supplied, not attacker source
    }
}
