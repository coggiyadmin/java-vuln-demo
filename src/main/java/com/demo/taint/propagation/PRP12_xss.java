package com.demo.taint.propagation;
import javax.servlet.http.HttpServletRequest;
public class PRP12_xss {
    static String G;
    public String h(HttpServletRequest req) throws Exception {
        String s = req.getParameter("q"); // SOURCE
        G = s;
        String t = G; // static field
        return "<p>" + t + "</p>"; // SINK
    }
}
