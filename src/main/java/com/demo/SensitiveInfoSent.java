package com.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FN probe — CWE-201 Insertion of Sensitive Information Into Sent Data. The full user record,
 * including the password hash and API token, is serialized to the client. NO finding = FN.
 */
public class SensitiveInfoSent {

    public void me(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        String passwordHash = "$2b$12$abcdef";
        String apiToken = "sk-live-9931";
        // leaks passwordHash + apiToken to the client → CWE-201
        response.getWriter().printf("{\"id\":7,\"name\":\"ada\",\"passwordHash\":\"%s\",\"apiToken\":\"%s\"}",
                passwordHash, apiToken);
    }
}
