package com.demo;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-1173 Improper Use of Validation Framework. The validator is invoked but its
 * result is discarded, so invalid input proceeds. Real vuln; NO finding = FN.
 */
public class ImproperValidation {

    private static final Pattern EMAIL = Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");

    public void subscribe(HttpServletRequest request) {
        String email = request.getParameter("email");
        EMAIL.matcher(email).matches();           // validation result IGNORED → CWE-1173
        saveSubscriber(email);                    // proceeds with unvalidated input
    }

    private void saveSubscriber(String e) {}
}
