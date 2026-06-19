package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * SAFE mirror — SensitiveDataLogging.java; only non-sensitive fields are logged.
 */
public class SafeSensitiveDataLogging {

    private static final Logger log = Logger.getLogger("app");

    public void login(HttpServletRequest request) {
        String user = request.getParameter("user");
        request.getParameter("password");          // used for auth, never logged
        log.info("login attempt user=" + user);    // no credential in the log
    }
}
