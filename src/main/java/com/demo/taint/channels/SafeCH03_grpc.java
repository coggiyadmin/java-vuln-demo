package com.demo.taint.channels;
public class SafeCH03_grpc {
  public void handle(String payload) throws Exception {
    ProcessBuilder pb = new ProcessBuilder("echo", payload);
    pb.start();
  }
}
