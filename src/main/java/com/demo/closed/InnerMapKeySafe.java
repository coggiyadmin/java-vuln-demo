package com.demo.closed;
import javax.servlet.http.*;
public class InnerMapKeySafe extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        org.owasp.benchmark.helpers.SeparateClassRequest scr =
                new org.owasp.benchmark.helpers.SeparateClassRequest(request);
        String param = scr.getTheParameter("BenchmarkTest");
        if (param == null) param = "";
        String bar = new Test().doSomething(request, param);
        response.getWriter().write(bar);
    }
    private class Test {
        public String doSomething(HttpServletRequest request, String param) {
            String bar = "safe!";
            java.util.HashMap<String, Object> map = new java.util.HashMap<String, Object>();
            map.put("keyA", "a_Value");
            map.put("keyB", param);
            map.put("keyC", "another_Value");
            bar = (String) map.get("keyB");
            bar = (String) map.get("keyA");
            return bar;
        }
    }
}
