package com.demo;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — ExposedMethod.java; the privileged action requires an authenticated admin.
 */
public class SafeExposedMethod {

    public void maintenance(HttpServletRequest request) throws IOException {
        String token = request.getHeader("X-Admin-Token");
        if (!Objects.equals(token, System.getenv("ADMIN_TOKEN"))) {  // auth gate
            throw new SecurityException("forbidden");
        }
        Runtime.getRuntime().exec(new String[]{"/opt/app/bin/cleanup.sh"});
    }
}
