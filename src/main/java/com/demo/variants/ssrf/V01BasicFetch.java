package com.demo.variants.ssrf;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V01BasicFetch {
    public void fetch(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String url = req.getParameter("url"); // SOURCE
        var r = HttpClient.newHttpClient().send(
            HttpRequest.newBuilder(URI.create(url)).build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()); // SINK CWE-918
        res.getWriter().print(r.body());
    }
}
