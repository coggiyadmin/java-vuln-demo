package com.demo.flow.tier1.command_injection;
import javax.servlet.http.HttpServletRequest;
public class V07HardeningSafe {
    public void run(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q");
        if (q.matches(".*[;|&$`].*")) throw new SecurityException();
        Runtime.getRuntime().exec(new String[] {"grep", q, "/var/log/app.log"});
    }
}
