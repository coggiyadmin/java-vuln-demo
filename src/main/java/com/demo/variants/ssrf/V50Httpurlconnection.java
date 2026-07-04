package com.demo.variants.ssrf;

import java.net.URL;
import java.net.HttpURLConnection;
import javax.servlet.http.HttpServletRequest;
public class V50Httpurlconnection {
    public void fetch(HttpServletRequest req) throws Exception {
        String target = req.getParameter("url"); // SOURCE
        HttpURLConnection c = (HttpURLConnection) new URL(target).openConnection(); // SINK CWE-918
        c.getInputStream();
    }
}
