package com.demo;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * FN probe — CWE-779 Logging of Sensitive Data. The user's password is written to the log.
 * (CWE-532 family.)
 */
public class SensitiveDataLogging {

    private static final Logger log = Logger.getLogger("app");

    public void login(HttpServletRequest request) {
        String user = request.getParameter("user");
        String pw = request.getParameter("password");   // SOURCE — credential
        log.info("login attempt user=" + user + " password=" + pw);  // logs the password → CWE-779
    }
}
