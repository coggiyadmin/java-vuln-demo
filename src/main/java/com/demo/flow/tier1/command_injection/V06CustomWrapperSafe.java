package com.demo.flow.tier1.command_injection;
import javax.servlet.http.HttpServletRequest;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace(";", ""); }
    public void run(HttpServletRequest req) throws Exception {
        Runtime.getRuntime().exec(new String[] {"grep", companySanitize(req.getParameter("q")), "/var/log/app.log"});
    }
}
