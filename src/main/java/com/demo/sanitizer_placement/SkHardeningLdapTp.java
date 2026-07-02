package com.demo.sanitizer_placement;
import javax.naming.directory.*;
import javax.servlet.http.*;
public class SkHardeningLdapTp {
  public void handle(HttpServletRequest req, DirContext ctx) throws Exception {
    String uid = req.getParameter('uid').replace('*', '');
    ctx.search('ou=people', '(uid=' + uid + ')', new SearchControls());
  }
}
