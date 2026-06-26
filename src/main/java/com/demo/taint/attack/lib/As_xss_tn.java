package com.demo.taint.attack.lib;
public class As_xss_lib {
  public String publicRender(String name) { return "<p>" + name + "</p>"; }
}
