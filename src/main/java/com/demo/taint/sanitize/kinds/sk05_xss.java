package com.demo.taint.sanitize.kinds;
public class SK05_xss {
  static String companySanitize(String x) { return x.replace(";", ""); }
  public void run(String q) throws Exception {
    Runtime.getRuntime().exec("grep " + companySanitize(q) + " /var/log/app.log"); // SK-05 TN
  }
}
