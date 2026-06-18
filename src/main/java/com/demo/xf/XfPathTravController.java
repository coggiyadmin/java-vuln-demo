package com.demo.xf;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

public class XfPathTravController {
    public InputStream handle(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");   // SOURCE
        return XfPathTravHelper.run(name);         // cross-file call (CWE-22)
    }
}
