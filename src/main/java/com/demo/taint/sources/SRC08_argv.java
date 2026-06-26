package com.demo.taint.sources;
public class SrcArgv {
  public static void main(String[] args) throws Exception {
    String v = args.length > 0 ? args[0] : ""; // SOURCE SRC-08
    Runtime.getRuntime().exec("echo " + v);
  }
}
