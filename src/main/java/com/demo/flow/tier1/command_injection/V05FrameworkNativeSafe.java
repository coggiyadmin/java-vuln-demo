package com.demo.flow.tier1.command_injection;
import javax.servlet.http.HttpServletRequest;
public class V05FrameworkNativeSafe {
    public void run(HttpServletRequest req) throws Exception {
        Runtime.getRuntime().exec(new String[] {"grep", req.getParameter("q"), "/var/log/app.log"});
    }
}
