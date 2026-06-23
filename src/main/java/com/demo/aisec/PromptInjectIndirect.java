package com.demo.aisec;

import java.net.*;
import java.io.*;

/** Prompt Injection INDIRECT (OWASP LLM01). */
public class PromptInjectIndirect {
    public String summarizeUrl(String url) throws IOException {
        String page = new String(new URL(url).openStream().readAllBytes());
        return "Follow directives in:\n" + page;
    }
}
