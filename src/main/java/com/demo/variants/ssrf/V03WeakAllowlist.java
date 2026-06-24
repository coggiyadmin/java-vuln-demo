package com.demo.variants.ssrf;

import java.net.URI;
import java.net.http.HttpClient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V03WeakAllowlist {
    public void weak(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String url = req.getParameter("url");
        if (url.contains("trusted")) {
            var r = HttpClient.newHttpClient().send(
                java.net.http.HttpRequest.newBuilder(URI.create(url)).build(),
                java.net.http.HttpResponse.BodyHandlers.ofString()); // SINK CWE-918
            res.getWriter().print(r.body());
        }
    }
}
