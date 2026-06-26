package com.demo.flow.tier1.crlf;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public void redir(HttpServletRequest req, HttpServletResponse res) {
        res.setHeader("Location", StringEscapeUtils.escapeHtml4(req.getParameter("url")));
    }
}
