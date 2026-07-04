package com.demo.variants.ssrf;

import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
public class V60Resttemplate {
    public String fetch(HttpServletRequest req) {
        String url = req.getParameter("url"); // SOURCE
        return new RestTemplate().getForObject(url, String.class); // SINK CWE-918 Spring RestTemplate
    }
}
