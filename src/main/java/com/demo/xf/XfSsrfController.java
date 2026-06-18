package com.demo.xf;

import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;

public class XfSsrfController {
    public InputStream handle(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url");   // SOURCE
        return XfSsrfHelper.run(url);            // cross-file call (CWE-918)
    }
}
