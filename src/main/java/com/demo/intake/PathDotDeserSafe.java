package com.demo.intake;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;

/** Safe mirror — opaque upload id only; canonical guard; no deserialization. */
public class PathDotDeserSafe {
    private static final File UPLOAD_ROOT = new File("/var/app/uploads");

    public void uploadOnly(HttpServletRequest req) throws Exception {
        File dest = new File(UPLOAD_ROOT, java.util.UUID.randomUUID() + ".dat");
        File resolved = dest.getCanonicalFile();
        if (!resolved.toPath().startsWith(UPLOAD_ROOT.getCanonicalFile().toPath())) {
            return;
        }
        try (FileOutputStream fos = new FileOutputStream(resolved)) {
            fos.write(req.getParameter("body").getBytes());
        }
    }
}
