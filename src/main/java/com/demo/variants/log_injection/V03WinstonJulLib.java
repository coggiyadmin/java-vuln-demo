package com.demo.variants.log_injection;

import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
public class V03WinstonJulLib {
    public void jul(HttpServletRequest req) {
        String user = req.getParameter("user");
        Logger.getLogger("app").warning("user=" + user); // SINK CWE-117 java.util.logging
    }
}
