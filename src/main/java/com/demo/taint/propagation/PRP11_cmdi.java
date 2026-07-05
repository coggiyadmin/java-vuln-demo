package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
public class PRP11_cmdi {
    public void h(HttpServletRequest req) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        final String[] cap = { s };
        java.util.function.Supplier<String> f = () -> cap[0];
        String t = f.get(); // closure capture
        Runtime.getRuntime().exec("grep " + t); // SINK
    }
}
