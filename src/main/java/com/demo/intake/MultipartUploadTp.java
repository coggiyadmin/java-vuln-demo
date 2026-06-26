package com.demo.intake;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/** TP — unrestricted multipart upload (CWE-434 intake pattern). CVE-2021-26828 class. */
public class MultipartUploadTp {
    private static final File UPLOAD_ROOT = new File("/var/www/uploads");

    public void upload(HttpServletRequest req) throws Exception {
        Part part = req.getPart("file");
        String filename = part.getSubmittedFileName();
        part.write(new File(UPLOAD_ROOT, filename).getPath()); // SINK CWE-434
    }
}
