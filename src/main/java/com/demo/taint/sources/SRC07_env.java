package com.demo.taint.sources;
public class SrcEnv {
  public void run() throws Exception {
    String v = System.getenv("TARGET"); // SOURCE SRC-07
    Runtime.getRuntime().exec("echo " + v);
  }
}
