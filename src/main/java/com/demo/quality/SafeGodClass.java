package com.demo.quality;

import java.util.*;

/** SAFE mirror — split responsibilities. */
public class SafeGodClass {
    public static class Users {
        private final List<String> users = new ArrayList<>();
        public void add(String u) { users.add(u); }
    }
    public static class Html {
        public String title(String name) { return "<h1>" + name + "</h1>"; }
    }
}
