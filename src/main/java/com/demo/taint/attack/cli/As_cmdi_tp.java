package com.demo.taint.attack.cli;
public class As_cmdi_cli {
  public static void main(String[] args) throws Exception {
    String q = args.length > 0 ? args[0] : "";
    Runtime.getRuntime().exec("grep " + q); // CLI SOURCE
  }
}
