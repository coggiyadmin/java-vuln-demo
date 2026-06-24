// FP-target (elarasu cognium-dev#167) — picocli `new CommandLine(spec)` only builds a parser;
// it executes nothing. Must not be flagged command_injection.
package com.demo.libapi;

import picocli.CommandLine;

public class SafePicocliConstructor {
    public CommandLine build(Object spec) {
        return new CommandLine(spec); // constructor — NOT a sink
    }
}
