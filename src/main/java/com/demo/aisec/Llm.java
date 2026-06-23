// Test helper — stand-in LLM client so aisec probes compile without a live SDK.
package com.demo.aisec;

final class Llm {
    static String chatSystem(String system, String user) { return ""; }
    static String chatSystemUser(String system, String user) { return ""; }
}
