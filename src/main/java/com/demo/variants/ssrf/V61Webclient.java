package com.demo.variants.ssrf;

import org.springframework.web.reactive.function.client.WebClient;
import javax.servlet.http.HttpServletRequest;
public class V61Webclient {
    public String fetch(HttpServletRequest req) {
        String url = req.getParameter("url"); // SOURCE
        return WebClient.create().get().uri(url).retrieve().bodyToMono(String.class).block(); // SINK CWE-918 WebClient
    }
}
