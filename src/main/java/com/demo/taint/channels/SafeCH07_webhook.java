package com.demo.taint.channels;
public class SafeCH07_webhook {
  public void onWebhook(String repoName) throws Exception {
    if (!repoName.matches("^[A-Za-z0-9_-]+$")) return;
    new ProcessBuilder("git", "clone", "/srv/" + repoName).start();
  }
}
