package com.demo.aisec;

import java.util.Set;

/** SAFE mirror — allowlisted commands. */
public class SafeAgentExcessiveAgency {
    private static final Set<String> ALLOW = Set.of("pwd", "date");

    public String shellTool(String command) throws Exception {
        if (!ALLOW.contains(command)) throw new SecurityException("not allowed");
        Process p = switch (command) {
            case "pwd" -> new ProcessBuilder("pwd").start();
            case "date" -> new ProcessBuilder("date").start();
            default -> throw new SecurityException("not allowed");
        };
        return new String(p.getInputStream().readAllBytes());
    }
}
