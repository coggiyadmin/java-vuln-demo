package com.demo;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

/** CWE-59 — Link Following. Files.readAllBytes follows a symlink in an attacker-writable
 * directory to a sensitive file. (Engine gap.) FN probe. */
public class SymlinkFollow {
    private static final String UPLOADS = "/var/app/uploads/";

    public byte[] cat(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");          // SOURCE
        return Files.readAllBytes(Paths.get(UPLOADS + name));  // symlink followed → CWE-59
    }
}
