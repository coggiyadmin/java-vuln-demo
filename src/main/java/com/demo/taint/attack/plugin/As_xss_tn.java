package com.demo.taint.attack.plugin;
public class As_xss_plugin {
  public String publicRender(String name) { return "<p>" + name + "</p>"; }
}
