package com.demo.taint.channels;
public class SafeCH04_serverless {
  public void handler(String cmd) throws Exception {
    if (cmd.matches("^[a-z0-9_-]+$")) {
      new ProcessBuilder("echo", cmd).start();
    }
  }
}
