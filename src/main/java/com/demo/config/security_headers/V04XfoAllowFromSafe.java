package com.demo.config.security_headers;

import javax.servlet.http.HttpServletResponse;
public class V04XfoAllowFromSafe {
    public void headers(HttpServletResponse res) {
        res.setHeader("Content-Security-Policy", "frame-ancestors 'self'");
    }
}
