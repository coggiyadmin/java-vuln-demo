package com.demo.config.security_headers;

import javax.servlet.http.HttpServletResponse;
public class V04XfoAllowFromTp {
    public void headers(HttpServletResponse res) {
        res.setHeader("X-Frame-Options", "ALLOW-FROM https://evil.example"); // SINK CWE-1021
    }
}
