package com.demo.config.security_headers;

import javax.servlet.http.HttpServletResponse;
public class V01CorsWildcardSafe {
    public void headers(HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", "https://app.example.com");
    }
}
