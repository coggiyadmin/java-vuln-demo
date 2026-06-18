package com.demo;

import java.io.FileInputStream;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;

/** Combination #13 — ENCODED PAYLOAD × PATH TRAVERSAL (CWE-22). base64-decode preserves taint. */
public class EncodedPathTrav {

    public void x(HttpServletRequest req) throws Exception {
        String name = new String(Base64.getDecoder().decode(req.getParameter("b64"))); // decode
        new FileInputStream("/srv/app/data/" + name); // CWE-22
    }
}
