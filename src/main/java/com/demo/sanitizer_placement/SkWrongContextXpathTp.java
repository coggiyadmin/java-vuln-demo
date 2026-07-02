package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
public class SkWrongContextXpathTp {
  public void handle(HttpServletRequest req, XPath xp) throws Exception {
    String name = req.getParameter("name").replace("<", "&lt;");
    xp.evaluate("//user[name='" + name + "']", new InputSource());
  }
}
