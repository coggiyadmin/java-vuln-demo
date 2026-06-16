package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class C3v { public String run(HttpServletRequest req, Connection cn) throws Exception {
    String[] ps=req.getParameterValues("p"); for(String v: ps){ cn.createStatement().executeQuery("SELECT "+v); }
 return ""; } }
