package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
public class SkCustomWrapperXpathTp {
  private static String companySanitize(String v) { return v.replace("'", "").replace(""", ""); }
  public void handle(HttpServletRequest req, XPath xp) throws Exception {
    String name = companySanitize(req.getParameter("name"));
    xp.evaluate("//user[name='" + name + "']", new InputSource());
  }
}
