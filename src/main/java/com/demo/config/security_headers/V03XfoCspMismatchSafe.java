package com.demo.config.security_headers;

import javax.servlet.http.HttpServletResponse;
public class V03XfoCspMismatchSafe {
    public void headers(HttpServletResponse res) {
        res.setHeader("X-Frame-Options", "DENY");
        res.setHeader("Content-Security-Policy", "frame-ancestors 'none'");
    }
}
