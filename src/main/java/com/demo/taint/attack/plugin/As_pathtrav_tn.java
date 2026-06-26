package com.demo.taint.attack.plugin;
public class As_pathtrav_plugin {
  public String publicRead(String path) throws Exception {
    return java.nio.file.Files.readString(java.nio.file.Path.of("/data", path));
  }
}
