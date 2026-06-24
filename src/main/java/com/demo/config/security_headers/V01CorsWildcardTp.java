package com.demo.config.security_headers;

import javax.servlet.http.HttpServletResponse;
public class V01CorsWildcardTp {
    public void headers(HttpServletResponse res) {
        res.setHeader("Access-Control-Allow-Origin", "*"); // SINK CWE-942
    }
}
