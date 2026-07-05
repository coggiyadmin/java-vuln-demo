package com.demo.variants.ssrf;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import javax.servlet.http.HttpServletRequest;
public class V80ApacheHttpclient {
    public void fetch(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url"); // SOURCE
        HttpClients.createDefault().execute(new HttpGet(url)); // SINK CWE-918 Apache HttpClient
    }
}
