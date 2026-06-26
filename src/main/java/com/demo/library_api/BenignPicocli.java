package com.demo.library_api;

import picocli.CommandLine;

/** TN — picocli constructor is not command injection (#167). */
public class BenignPicocli {
    static class App implements Runnable {
        public void run() { System.out.println("ok"); }
    }
    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
