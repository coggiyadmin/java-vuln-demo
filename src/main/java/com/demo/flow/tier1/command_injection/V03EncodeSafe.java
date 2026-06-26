package com.demo.flow.tier1.command_injection;
import javax.servlet.http.HttpServletRequest;
public class V03EncodeSafe {
    public void run(HttpServletRequest req) throws Exception {
        String q = req.getParameter("q").replaceAll("[;|&`$]", "");
        Runtime.getRuntime().exec(new String[] {"grep", q, "/var/log/app.log"});
    }
}
