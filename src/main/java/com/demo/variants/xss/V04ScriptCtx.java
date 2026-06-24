package com.demo.variants.xss;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class V04ScriptCtx {
    public void script(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String t = req.getParameter("t");
        res.getWriter().print("<script>var x="" + t + ""</script>"); // SINK CWE-79
    }
}
