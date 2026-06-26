package com.demo.taint.attack.lib;
public class As_pathtrav_lib {
  public String publicRead(String path) throws Exception {
    return java.nio.file.Files.readString(java.nio.file.Path.of("/data", path));
  }
}
