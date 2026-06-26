package com.demo.intake;

import java.io.File;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/** Safe mirror — extension allowlist + opaque stored name. */
public class MultipartUploadSafe {
    private static final File UPLOAD_ROOT = new File("/var/www/uploads");
    private static final Set<String> ALLOWED = Set.of(".png", ".jpg", ".pdf");

    public void upload(HttpServletRequest req) throws Exception {
        Part part = req.getPart("file");
        String name = part.getSubmittedFileName();
        String ext = name.contains(".") ? name.substring(name.lastIndexOf('.')).toLowerCase() : "";
        if (!ALLOWED.contains(ext)) {
            throw new SecurityException("unsupported type");
        }
        String stored = java.util.UUID.randomUUID() + ext;
        part.write(new File(UPLOAD_ROOT, stored).getPath());
    }
}
