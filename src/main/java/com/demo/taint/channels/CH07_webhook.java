package com.demo.taint.channels;
public class CH07_webhook {
  public void onWebhook(String repoName) throws Exception {
    Runtime.getRuntime().exec("git clone /srv/" + repoName); // SINK CWE-78
  }
}
