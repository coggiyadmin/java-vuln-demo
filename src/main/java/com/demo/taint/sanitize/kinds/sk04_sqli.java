package com.demo.taint.sanitize.kinds;
import org.owasp.encoder.Encode;
public class SK04_sqli {
  public String render(String name) {
    return Encode.forHtml("<p>" + name + "</p>"); // SK-04 framework native TN
  }
}
