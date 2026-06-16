package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class InjectionTest { public void run(HttpServletRequest req, Connection cn) throws Exception {
  String u = req.getParameter("u"); cn.createStatement().executeQuery("SELECT " + u);
}}
