package com.demo.flow.tier1.ssrf;
import java.net.*; import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public void fetch(HttpServletRequest req) throws Exception {
        String u = StringEscapeUtils.escapeHtml4(req.getParameter("url"));
        new URL(u).openStream(); // HTML escape wrong for SSRF TP
    }
}
