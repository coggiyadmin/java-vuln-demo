package com.demo;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * FN probe — CWE-215 Insertion of Sensitive Information Into Debugging Code. A debug branch
 * returns the stack trace and DB credentials to the client. NO finding = FN.
 */
public class SensitiveInfoDebug {

    private static final boolean DEBUG = "1".equals(System.getenv("DEBUG"));

    public void op(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException {
        try {
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            if (DEBUG) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                // leaks stack + secrets through a debug path → CWE-215
                response.getWriter().print(sw + "\nDB_PASSWORD=" + System.getenv("DB_PASSWORD"));
                return;
            }
            response.sendError(500, "error");
        }
    }
}
