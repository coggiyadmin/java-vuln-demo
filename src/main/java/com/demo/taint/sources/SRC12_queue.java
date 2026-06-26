package com.demo.taint.sources;
public class SrcQueue {
  public void onMessage(java.util.Map<String,Object> payload) throws Exception {
    String q = String.valueOf(payload.get("body")); // SOURCE SRC-12
    Runtime.getRuntime().exec("echo " + q);
  }
}
