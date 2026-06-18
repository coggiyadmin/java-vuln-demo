package com.demo.xf;

import javax.servlet.http.HttpServletRequest;
import org.w3c.dom.Document;

public class XfXPathController {
    public String handle(HttpServletRequest req, Document doc) throws Exception {
        String name = req.getParameter("name");   // SOURCE
        return XfXPathHelper.run(doc, name);       // cross-file call (CWE-643)
    }
}
