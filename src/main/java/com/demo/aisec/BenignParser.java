// TN — benign parser; trims and drops blank lines.
package com.demo.aisec;

import java.util.ArrayList;
import java.util.List;

public class BenignParser {
    public List<String> parseLines(List<String> lines) {
        List<String> out = new ArrayList<>();
        for (String l : lines) { String t = l.strip(); if (!t.isEmpty()) out.add(t); }
        return out;
    }
}
