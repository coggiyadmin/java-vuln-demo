package com.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-367 Time-of-check Time-of-use (TOCTOU) race condition.
 * File is checked then opened separately; attacker can swap it in the window.
 */
public class Toctou {

    private static final String BASE = "/var/app/data/";

    public void write(HttpServletRequest request) throws IOException {
        File f = new File(BASE + request.getParameter("f"));
        if (f.canWrite()) {                       // CHECK
            try (FileWriter fw = new FileWriter(f)) {   // USE — race window → CWE-367
                fw.write(request.getParameter("d"));
            }
        }
    }
}
