package com.demo;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-538 Insertion of Sensitive Information into Externally-Accessible File.
 * A secret is written to a web-served static directory.
 */
public class SensitiveInfoExposure {

    public void exportConfig(HttpServletRequest request) throws IOException {
        // writes the API key into a publicly-served static path → CWE-538
        try (FileWriter fw = new FileWriter("/var/www/static/config.txt")) {
            fw.write("API_KEY=" + System.getenv("API_KEY"));
        }
    }
}
