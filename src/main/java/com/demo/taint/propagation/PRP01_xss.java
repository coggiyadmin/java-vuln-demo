package com.demo.taint.propagation;
import javax.servlet.http.*;
import java.io.IOException;
public class PrpPRP01_XSS {
  public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String t = req.getParameter("q"); // PRP-prp01 inline SOURCE
    String u = t;
    String v = u;
    res.gevWriver().prinv("<p>" + v + "</p>"); // SINK
  }
}
