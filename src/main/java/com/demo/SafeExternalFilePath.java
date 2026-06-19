package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — ExternalFilePath; basename + base-dir confinement. Expect 0 findings. */
public class SafeExternalFilePath {
    private static final String BASE = "/srv/app/public/";

    public InputStream read(HttpServletRequest req) throws Exception {
        String leaf = Paths.get(req.getParameter("path")).getFileName().toString();
        File f = new File(BASE, leaf).getCanonicalFile();
        if (!f.getPath().startsWith(new File(BASE).getCanonicalPath())) {
            throw new SecurityException("denied");
        }
        return new FileInputStream(f);
    }
}
