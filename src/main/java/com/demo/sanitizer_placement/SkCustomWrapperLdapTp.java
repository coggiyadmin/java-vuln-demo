package com.demo.sanitizer_placement;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class SkCustomWrapperLdapTp {
  private static String companySanitize(String v) { return v.replace("(", "").replace(")", ""); }
  public void handle(HttpServletRequest req, DirContext ctx) throws Exception {
    String uid = companySanitize(req.getParameter("uid"));
    ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls());
  }
}
