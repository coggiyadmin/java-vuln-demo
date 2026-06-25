package com.demo.intake;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** TP — REST file fetch with weak prefix guard (CWE-22). Commvault-style path traversal intake. */
public class RestPathTraversalTp {
    private static final String BASE = "/opt/commvault/data";

    public void download(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String file = req.getParameter("file");
        String full = BASE + "/" + file;
        if (full.startsWith(BASE)) {
            byte[] data = Files.readAllBytes(Paths.get(full)); // SINK CWE-22
            res.getOutputStream().write(data);
        }
    }
}
