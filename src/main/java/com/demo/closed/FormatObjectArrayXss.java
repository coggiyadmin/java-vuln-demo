package com.demo.closed;
import java.util.Locale;
import javax.servlet.http.*;
// cognium-dev#598 — tainted value in the argument array, constant format
public class FormatObjectArrayXss extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    String bar = req.getParameter("q");
    Object[] obj = {"a", bar};
    resp.getWriter().format(Locale.US, "Formatted like: %1$s and %2$s.", obj); // SINK CWE-79
  }
}
