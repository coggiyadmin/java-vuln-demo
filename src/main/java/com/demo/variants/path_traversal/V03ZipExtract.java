package com.demo.variants.path_traversal;

import java.util.zip.ZipInputStream;
import javax.servlet.http.HttpServletRequest;
public class V03ZipExtract {
    public void unzip(HttpServletRequest req) throws Exception {
        var zis = new ZipInputStream(req.getInputStream());
        var e = zis.getNextEntry();
        java.nio.file.Files.copy(zis, java.nio.file.Paths.get("/tmp/out", e.getName())); // SINK CWE-22
    }
}
