package com.demo.intake;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/** TP — Spring Cloud Config path traversal (CWE-22). CVE-2020-5410 class. */
public class SpringCloudConfigPathTp {
    public InputStream fetch(HttpServletRequest req) throws Exception {
        String path = req.getParameter("path");
        return new FileInputStream("/config/" + path); // SINK CWE-22
    }
}
