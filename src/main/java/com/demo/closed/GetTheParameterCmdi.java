package com.demo.closed;
import javax.servlet.http.*;
public class GetTheParameterCmdi extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest02433");
        if (param == null) param = "";
        String bar = doSomething(request, param);
        String[] args = new String[] {"sh", "-c", "ls " + bar};
        Runtime.getRuntime().exec(args);
    }
    private static String doSomething(HttpServletRequest request, String param) {
        return param;
    }
}
