// FP-target (upstream cognium-dev#155) — a Markdown parser's parse() produces an AST, it does
// not execute code. Must not be flagged code_injection.
package com.demo.libapi;

import org.commonmark.parser.Parser;
import org.commonmark.node.Node;

public class SafeMarkdownParse {
    private static final Parser PARSER = Parser.builder().build();
    public Node render(String markdown) {
        return PARSER.parse(markdown); // AST build — NOT code execution
    }
}
