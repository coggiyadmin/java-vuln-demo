// FP-target (#169) — CLI profile. A local scripting dev-tool that evals a file argument;
// operator-controlled, not a remote sink. project-profile=cli should downgrade.
package com.demo.profile.cli;

import javax.script.ScriptEngineManager;

public final class ScriptEvalCli {
    public static void main(String[] args) throws Exception {
        new ScriptEngineManager().getEngineByName("js").eval(new java.io.FileReader(args[0]));
    }
}
