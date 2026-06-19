package com.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — SensitiveInfoExposure.java; secret written to a private, non-served path.
 */
public class SafeSensitiveInfoExposure {

    public void exportConfig(HttpServletRequest request) throws IOException {
        Path target = Paths.get("/var/app/private/config.txt");  // not web-accessible
        try (OutputStream os = Files.newOutputStream(target, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE)) {
            os.write(("API_KEY=" + System.getenv("API_KEY")).getBytes());
        }
    }
}
