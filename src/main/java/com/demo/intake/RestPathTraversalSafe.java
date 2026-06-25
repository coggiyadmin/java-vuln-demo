package com.demo.intake;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

/** Safe mirror — canonical path guard (mirrors SafeService.readUpload). */
public class RestPathTraversalSafe {
    private static final String BASE = "/opt/commvault/data";

    public String download(HttpServletRequest req) throws IOException {
        String file = req.getParameter("file");
        File base = new File(BASE);
        File target = new File(base, file);
        String canonical = target.getCanonicalPath();
        if (!canonical.startsWith(base.getCanonicalPath() + File.separator)) {
            throw new SecurityException("path traversal blocked");
        }
        return new String(Files.readAllBytes(Paths.get(canonical)));
    }
}
