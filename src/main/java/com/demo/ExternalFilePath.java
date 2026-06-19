package com.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

/** CWE-73 — External Control of File Name or Path. User controls the full path. NO finding = FN. */
public class ExternalFilePath {
    public InputStream read(HttpServletRequest req) throws Exception {
        String path = req.getParameter("path");   // SOURCE — full path
        return new FileInputStream(path);          // arbitrary file read → CWE-73
    }
}
