package com.demo.flow.tier1.command_injection;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public void run(HttpServletRequest req) throws Exception {
        String q = StringEscapeUtils.escapeHtml4(req.getParameter("q"));
        Runtime.getRuntime().exec("grep " + q); // HTML escape wrong for cmdi TP
    }
}
