package com.demo.flow.tier1.open_redirect;
import javax.servlet.http.*;
import java.util.Set;
public class V05FrameworkNativeSafe {
    private static final Set<String> ALLOWED = Set.of("/dashboard", "/profile");
    public void go(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String nxt = req.getParameter("next");
        if (!ALLOWED.contains(nxt)) throw new SecurityException();
        res.sendRedirect(nxt);
    }
}
