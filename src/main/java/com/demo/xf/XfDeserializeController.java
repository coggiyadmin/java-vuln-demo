package com.demo.xf;

import javax.servlet.http.HttpServletRequest;

public class XfDeserializeController {
    public Object handle(HttpServletRequest req) throws Exception {
        String s = req.getParameter("s");          // SOURCE
        return XfDeserializeHelper.run(s);         // cross-file call (CWE-502)
    }
}
