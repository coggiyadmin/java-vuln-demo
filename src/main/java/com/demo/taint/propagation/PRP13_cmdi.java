package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
public class PRP13_cmdi {
    public void h(HttpServletRequest req) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        java.util.Map<String,String> m = new java.util.HashMap<>(); m.put("v", s);
        String t = m.get("v"); // map round-trip
        Runtime.getRuntime().exec("grep " + t); // SINK
    }
}
