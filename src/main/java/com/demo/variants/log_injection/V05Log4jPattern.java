package com.demo.variants.log_injection;

import org.apache.logging.log4j.LogManager;
import javax.servlet.http.HttpServletRequest;
public class V05Log4jPattern {
    private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(V05Log4jPattern.class);
    public void log4j(HttpServletRequest req) {
        String user = req.getParameter("user"); // SOURCE
        log.info("login user=${" + user + "}"); // SINK CWE-117 Log4j pattern
    }
}
