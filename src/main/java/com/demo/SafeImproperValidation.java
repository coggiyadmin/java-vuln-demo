package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — ImproperValidation.java; the validator result is enforced before use.
 */
public class SafeImproperValidation {

    private static final Pattern EMAIL = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    public void subscribe(HttpServletRequest request) {
        String email = request.getParameter("email");
        if (!EMAIL.matcher(email).matches()) {    // result enforced
            throw new IllegalArgumentException("invalid email");
        }
        saveSubscriber(email);
    }

    private void saveSubscriber(String e) {}
}
