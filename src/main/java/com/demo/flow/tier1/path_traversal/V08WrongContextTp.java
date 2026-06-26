package com.demo.flow.tier1.path_traversal;
import java.io.*; import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
public class V08WrongContextTp {
    public String read(HttpServletRequest req) throws Exception {
        String p = StringEscapeUtils.escapeHtml4(req.getParameter("p"));
        return new String(new FileInputStream("/data/" + p).readAllBytes());
    }
}
