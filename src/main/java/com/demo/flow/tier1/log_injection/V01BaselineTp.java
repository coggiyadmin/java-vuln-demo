package com.demo.flow.tier1.log_injection;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
public class V01BaselineTp {
    private static final Logger LOG = Logger.getLogger("app");
    public void login(HttpServletRequest req) {
        String user = req.getParameter("user");
        String pw = req.getParameter("password"); // SOURCE
        LOG.info("login user=" + user + " password=" + pw); // SINK CWE-117
    }
}
