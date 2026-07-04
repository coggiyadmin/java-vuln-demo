package com.demo.variants.path_traversal;

import java.util.zip.ZipInputStream;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
public class V12ZipSlipExtract {
    public void unzip(HttpServletRequest req) throws Exception {
        ZipInputStream zis = new ZipInputStream(req.getInputStream()); // SOURCE
        zis.getNextEntry();
        new FileOutputStream("/var/www/" + req.getParameter("name")).write(zis.readAllBytes()); // SINK CWE-22
    }
}
