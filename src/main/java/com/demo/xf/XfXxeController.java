package com.demo.xf;

import javax.servlet.http.HttpServletRequest;
import org.w3c.dom.Document;

public class XfXxeController {
    public Document handle(HttpServletRequest req) throws Exception {
        String xml = req.getParameter("xml");      // SOURCE
        return XfXxeHelper.run(xml);               // cross-file call (CWE-611)
    }
}
