package com.demo.closed;
import javax.servlet.http.*;
import org.apache.commons.text.StringEscapeUtils;
// cognium-dev#641
public class PartialSanitizeConcat extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String a = req.getParameter("a");
    String b = req.getParameter("b");
    resp.getWriter().println(StringEscapeUtils.escapeHtml4(a) + b); // SINK CWE-79
  }
}
