package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
public class PRP12_cmdi {
    static String G;
    public void h(HttpServletRequest req) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        G = s;
        String t = G; // static field
        Runtime.getRuntime().exec("grep " + t); // SINK
    }
}
