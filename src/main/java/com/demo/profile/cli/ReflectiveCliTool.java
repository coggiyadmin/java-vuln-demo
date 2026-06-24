// FP-target (elarasu cognium-dev#162) — CLI profile. A developer test-harness that
// reflectively loads a class named on the command line. Not a deployed attack surface;
// project-profile=cli should downgrade this, not ship it as critical RCE.
package com.demo.profile.cli;

public final class ReflectiveCliTool {
    public static void main(String[] args) throws Exception {
        Object t = Class.forName(args[0]).getDeclaredConstructor().newInstance(); // dev-CLI reflection
        System.out.println(t);
    }
}
