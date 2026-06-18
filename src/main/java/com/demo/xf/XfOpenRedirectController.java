package com.demo.xf;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XfOpenRedirectController {
    public void handle(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String url = req.getParameter("next");      // SOURCE
        XfOpenRedirectHelper.run(resp, url);        // cross-file call (CWE-601)
    }
}
