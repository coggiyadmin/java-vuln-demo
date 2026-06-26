package com.demo.flow.tier1.open_redirect;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String nxt = req.getParameter("next");
        if (nxt == null || !nxt.startsWith("/")) throw new SecurityException();
        res.sendRedirect(nxt);
    }
}
