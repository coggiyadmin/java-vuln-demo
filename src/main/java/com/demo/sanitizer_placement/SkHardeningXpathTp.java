package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
public class SkHardeningXpathTp {
  public void handle(HttpServletRequest req, XPath xp) throws Exception {
    String name = req.getParameter("name");
    if (name.length() > 256) throw new SecurityException("too long");
    xp.evaluate("//user[name='" + name + "']", new InputSource());
  }
}
