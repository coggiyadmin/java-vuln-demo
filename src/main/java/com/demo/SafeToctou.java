package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — Toctou.java; open atomically with exclusive create (no separate check).
 */
public class SafeToctou {

    private static final String BASE = "/var/app/data/";

    public void write(HttpServletRequest request) throws IOException {
        String leaf = Paths.get(request.getParameter("f")).getFileName().toString();
        Path target = Paths.get(BASE, leaf);
        try (OutputStream os = Files.newOutputStream(target, StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE)) {       // atomic exclusive create, no TOCTOU
            os.write(request.getParameter("d").getBytes());
        }
    }
}
