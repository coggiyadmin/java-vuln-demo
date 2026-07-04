package com.demo.variants.ssrf;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
public class V08SpringFetch {
    public byte[] springFetch(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");
        return new URL(url).openStream().readAllBytes(); // SINK CWE-918 Spring handler
    }
}
