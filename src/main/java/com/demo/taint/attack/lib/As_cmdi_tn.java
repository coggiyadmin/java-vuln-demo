package com.demo.taint.attack.lib;
public class As_cmdi_lib {
  public void publicRun(String userSupplied) throws Exception {
    Runtime.getRuntime().exec("grep " + userSupplied); // no HTTP entry — TN
  }
}
