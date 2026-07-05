package com.demo.taint.channels;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.text.StringEscapeUtils;
public class SafeCH08_sse {
  public String stream(HttpServletRequest req) {
    String msg = req.getParameter("msg");
    return "data: <p>" + StringEscapeUtils.escapeHtml4(msg) + "</p>\n\n";
  }
}
