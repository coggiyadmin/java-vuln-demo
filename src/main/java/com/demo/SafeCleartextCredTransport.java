package com.demo;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

/** SAFE mirror — CleartextCredTransport; credentials sent over HTTPS. Expect 0 findings. */
public class SafeCleartextCredTransport {
    public int login(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        HttpsURLConnection c = (HttpsURLConnection) new URL("https://auth.internal/login").openConnection();
        c.setRequestMethod("POST");
        c.setDoOutput(true);
        c.getOutputStream().write(("u=" + user + "&p=" + password).getBytes());
        return c.getResponseCode();
    }
}
