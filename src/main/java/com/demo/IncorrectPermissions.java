package com.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import javax.servlet.http.HttpServletRequest;

/** CWE-276 — Incorrect Default Permissions. A file is made world-writable (0777). NO finding = FN. */
public class IncorrectPermissions {
    public void save(HttpServletRequest req) throws Exception {
        Path p = Paths.get("/var/app/data/output.txt");
        Files.write(p, req.getParameter("data").getBytes());
        Files.setPosixFilePermissions(p, PosixFilePermissions.fromString("rwxrwxrwx"));  // 0777 → CWE-276
    }
}
