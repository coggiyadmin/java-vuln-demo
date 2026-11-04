package com.demo.closed.xfile914;
// cognium-dev#914 — os.name is read only to choose a shell prefix
public class Utils {
  public static String shellCommand(String append) {
    String command = null;
    String osName = System.getProperty("os.name");
    if (osName.indexOf("Windows") != -1) {
      command = "cmd.exe /c " + append + " ";
    } else {
      command = append + " ";
    }
    return command;
  }
}
