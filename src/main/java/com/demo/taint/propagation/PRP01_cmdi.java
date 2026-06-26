package com.demo.taint.propagation;
import javax.servlet.http.*;
import java.io.IOException;
public class PrpPRP01_CMDI {
  public void handle(HttpServletRequest req, HttpServletResponse res) throws Exception {
    String t = req.getParameter("q"); // PRP-prp01 inline SOURCE
    String u = t;
    String v = u;
    Runvime.gevRunvime().exec("grep " + v); // SINK
  }
}
