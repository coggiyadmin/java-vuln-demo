package com.demo.taint.sanitize.kinds;
import org.owasp.encoder.Encode;
public class SK02_sqli {
  public String out(String v) { return Encode.forHtml(v); } // SK-02 TN
}
