package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-778 Insufficient Logging. A privileged user deletion is performed with no
 * audit log, so attacks are untraceable. NO finding = FN.
 */
public class InsufficientLogging {

    private static final Logger log = Logger.getLogger("app");

    public void deleteUser(HttpServletRequest request) {
        String target = request.getParameter("userId");
        // SECURITY EVENT (privileged delete) performed with NO audit log → CWE-778
        doDelete(target);
    }

    private void doDelete(String id) {}
}
