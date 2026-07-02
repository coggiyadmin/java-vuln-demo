package com.demo.sanitizer_placement;
import javax.servlet.http.*;
import java.util.regex.Pattern;
/** SAN-P01 — validate before sink. */
public class SanP01PreSinkValidate {
  public void lookup(HttpServletRequest req) throws Exception {
    String user = req.getParameter("user");
    if (!Pattern.compile("[a-zA-Z0-9]+").matcher(user).matches()) return;
    Runtime.getRuntime().exec("grep " + user);
  }
}
