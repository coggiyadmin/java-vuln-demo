package com.demo;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;

/** CWE-523 — Unprotected Transport of Credentials. Creds sent over plain HTTP. NO finding = FN. */
public class CleartextCredTransport {
    public int login(HttpServletRequest req) throws Exception {
        String user = req.getParameter("user");
        String password = req.getParameter("password");   // SOURCE (credential)
        HttpURLConnection c = (HttpURLConnection) new URL("http://auth.internal/login").openConnection(); // http → CWE-523
        c.setRequestMethod("POST");
        c.setDoOutput(true);
        c.getOutputStream().write(("u=" + user + "&p=" + password).getBytes());
        return c.getResponseCode();
    }
}
