package com.demo.benign_corpus;

/** TN — ProcessBuilder fixed argv. */
public class BenignExecArgv {
    public Process grep(String pattern) throws Exception {
        return new ProcessBuilder("grep", pattern, "/var/log/app.log").start();
    }
}
