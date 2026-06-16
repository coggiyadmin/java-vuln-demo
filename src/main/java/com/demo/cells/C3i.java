package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class C3i { public void run(HttpServletRequest req, Connection cn) throws Exception {
  String[] ps = req.getParameterValues("p");      // String[] source?
  cn.createStatement().executeQuery("SELECT " + ps[0]);  // index, NO loop
}}
