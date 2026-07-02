package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
public class SkFakeXpathTp {
  public void handle(HttpServletRequest req, XPath xp) throws Exception {
    String name = req.getParameter("name").replace("SAFE", "");
    xp.evaluate("//user[name='" + name + "']", new InputSource());
  }
}
