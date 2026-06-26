package com.demo.library_api;

import java.util.regex.Pattern;

/** TN — Pattern.compile is not code_injection (#124). */
public class BenignPatternCompile {
    public static boolean matches(String input) {
        return Pattern.compile("^[a-z]+$").matcher(input).matches();
    }
}
