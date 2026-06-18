package com.demo.xf;

import javax.servlet.http.HttpServletRequest;

public class XfLogInjController {
    public void handle(HttpServletRequest req) {
        String user = req.getParameter("user");   // SOURCE
        XfLogInjHelper.run(user);                  // cross-file call (CWE-117)
    }
}
