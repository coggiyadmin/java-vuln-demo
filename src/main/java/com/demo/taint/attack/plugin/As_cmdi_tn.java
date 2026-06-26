package com.demo.taint.attack.plugin;
public class As_cmdi_plugin {
  public void publicRun(String userSupplied) throws Exception {
    Runtime.getRuntime().exec("grep " + userSupplied); // no HTTP entry — TN
  }
}
