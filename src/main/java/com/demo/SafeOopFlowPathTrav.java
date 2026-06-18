package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — OopFlowPathTrav; the tainted name is reduced to its file name and
 * confined to BASE before open. Expect 0 security findings.
 */
public class SafeOopFlowPathTrav {

    private static final String BASE = "/srv/app/data/";
    private final String name;

    public SafeOopFlowPathTrav(HttpServletRequest req) {
        this.name = req.getParameter("name");
    }

    private File safeFile() throws Exception {
        String leaf = Paths.get(this.name).getFileName().toString();  // strip ../ components
        File f = new File(BASE, leaf).getCanonicalFile();
        if (!f.getPath().startsWith(new File(BASE).getCanonicalPath())) {
            throw new SecurityException("path escapes base");
        }
        return f;
    }

    public InputStream readDirect() throws Exception {
        return new FileInputStream(safeFile());     // confined path reaches sink
    }
}
