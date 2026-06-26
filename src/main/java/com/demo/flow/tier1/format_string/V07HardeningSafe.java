package com.demo.flow.tier1.format_string;
import javax.servlet.http.*;
public class V07HardeningSafe {
    public void greet(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String name = req.getParameter("name");
        if (!name.matches("[A-Za-z0-9]+")) throw new SecurityException();
        res.getWriter().print("Hello " + name);
    }
}
