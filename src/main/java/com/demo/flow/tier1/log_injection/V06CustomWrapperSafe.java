package com.demo.flow.tier1.log_injection;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
public class V06CustomWrapperSafe {
    private static final Logger LOG = Logger.getLogger("app");
    public void login(HttpServletRequest req) {
        String user = req.getParameter("user");
        LOG.info("login user=" + user);
    }
}
