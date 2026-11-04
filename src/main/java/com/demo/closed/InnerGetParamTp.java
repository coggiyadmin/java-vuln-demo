package com.demo.closed;
import javax.servlet.http.*;
public class InnerGetParamTp extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest");
        if (param == null) param = "";
        String bar = new Test().doSomething(request, param);
        response.getWriter().print(bar);
    }
    private class Test {
        public String doSomething(HttpServletRequest request, String param) {
            String bar = "";
            if (param != null) bar = param.split(" ")[0];
            return bar;
        }
    }
}
