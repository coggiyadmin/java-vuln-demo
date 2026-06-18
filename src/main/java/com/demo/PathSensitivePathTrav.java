package com.demo;

import java.io.File;
import java.io.FileInputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Combination #2 — PATH-SENSITIVITY × PATH TRAVERSAL (CWE-22). Each method is a REAL
 * path traversal on at least one path. NO finding = FALSE NEGATIVE.
 */
public class PathSensitivePathTrav {

    private static final String BASE = "/srv/app/data/";

    public void neg(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (name.contains("..") || name.contains("/")) {
            new FileInputStream(BASE + name); // read anyway -> CWE-22
        }
    }

    public void oneBranch(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (req.getParameter("strict") != null) {
            name = new File(name).getName();
        }
        new FileInputStream(BASE + name); // else path tainted -> CWE-22
    }

    public void early(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        if (name.isEmpty()) {
            return;
        }
        new FileInputStream(BASE + name); // CWE-22
    }
}
