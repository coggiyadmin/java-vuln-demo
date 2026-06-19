package com.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — IncorrectPermissions; owner-only permissions (0600). Expect 0 findings. */
public class SafeIncorrectPermissions {
    public void save(HttpServletRequest req) throws Exception {
        Path p = Paths.get("/var/app/data/output.txt");
        Files.write(p, req.getParameter("data").getBytes());
        Files.setPosixFilePermissions(p, PosixFilePermissions.fromString("rw-------"));  // owner only
    }
}
