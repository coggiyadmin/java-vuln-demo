package com.demo.profile.cli;

/** TN — CLI main, no servlet source (#169). */
public class CliEntrypoint {
    public static void main(String[] args) {
        if (args.length > 0) System.out.println(args[0]);
    }
}
