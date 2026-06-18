package com.demo.xf;

import javax.servlet.http.HttpServletRequest;

public class XfSstiController {
    public Object handle(HttpServletRequest req) {
        String name = req.getParameter("name");   // SOURCE
        return XfSstiHelper.run(name);             // cross-file call (CWE-1336/917)
    }
}
