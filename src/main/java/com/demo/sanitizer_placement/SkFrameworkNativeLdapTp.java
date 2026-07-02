package com.demo.sanitizer_placement;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class SkFrameworkNativeLdapTp {
  public void handle(HttpServletRequest req, DirContext ctx) throws Exception {
    String uid = org.owasp.encoder.Encode.forHtml(req.getParameter("uid"));
    ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls());
  }
}
