package com.demo.flow.tier1.xpath;
import javax.xml.xpath.*;
import org.xml.sax.InputSource;
import javax.servlet.http.*;
public class V06CustomWrapperSafe {
    static String companySanitize(String x) { return x.replace("'", ""); }
    public void eval(HttpServletRequest req, XPath xp) throws Exception {
        String name = companySanitize(req.getParameter("name"));
        xp.evaluate("//user[name='" + name + "']", new InputSource());
    }
}
