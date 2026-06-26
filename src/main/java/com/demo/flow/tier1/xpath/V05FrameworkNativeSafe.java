package com.demo.flow.tier1.xpath;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import javax.servlet.http.*;
public class V05FrameworkNativeSafe {
    public void eval(HttpServletRequest req, XPath xp) throws Exception {
        String name = req.getParameter("name");
        if (!name.matches("[a-zA-Z0-9_-]+")) throw new SecurityException();
        xp.evaluate("//user[name='" + name + "']", new InputSource());
    }
}
