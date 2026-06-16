package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class C6v { public String run(HttpServletRequest req, Connection cn) throws Exception {
    String raw=req.getParameter("u"); String e=org.owasp.encoder.Encode.forHtml(raw); cn.createStatement().executeQuery("SELECT "+e);
 return ""; } }
