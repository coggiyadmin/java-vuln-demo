package com.demo.xf;

public class XfXssHelper {
    public static String renderTitle(String title) {
        return "<h1>" + title + "</h1>"; // CWE-79
    }
}
