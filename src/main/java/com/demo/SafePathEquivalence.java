package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — PathEquivalence; canonicalize first, then enforce extension + base prefix. */
public class SafePathEquivalence {
    private static final String BASE = "/srv/app/data/";

    public InputStream get(HttpServletRequest req) throws Exception {
        String leaf = Paths.get(req.getParameter("name")).getFileName().toString();
        File f = new File(BASE, leaf).getCanonicalFile();   // canonical form
        if (!f.getPath().startsWith(new File(BASE).getCanonicalPath()) || !f.getName().endsWith(".txt")) {
            throw new SecurityException("blocked");
        }
        return new FileInputStream(f);
    }
}
