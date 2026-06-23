package com.demo.quality;

import java.util.*;

/** Fowler god-class smell. */
public class GodClass {
    private List<String> users = new ArrayList<>();
    private Map<String, String> cache = new HashMap<>();
    public void addUser(String u) { users.add(u); }
    public String renderHtml(String name) { return "<h1>" + name + "</h1>"; }
    public String runShell(String cmd) throws Exception {
        return new String(Runtime.getRuntime().exec(cmd).getInputStream().readAllBytes());
    }
}
