package com.demo.variants.crlf;

import okhttp3.Request;
import javax.servlet.http.HttpServletRequest;
public class V05OkhttpHeader {
    public void okhttp(HttpServletRequest req) {
        String hdr = req.getParameter("hdr"); // SOURCE
        new Request.Builder().url("https://example.com").addHeader("X-User", hdr + "\r\nInjected: yes").build(); // SINK CWE-113
    }
}
