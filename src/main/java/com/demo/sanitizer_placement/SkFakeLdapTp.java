package com.demo.sanitizer_placement;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class SkFakeLdapTp {
  public void handle(HttpServletRequest req, DirContext ctx) throws Exception {
    String uid = req.getParameter("uid").replace("SAFE", "");
    ctx.search("ou=people", "(uid=" + uid + ")", new SearchControls());
  }
}
