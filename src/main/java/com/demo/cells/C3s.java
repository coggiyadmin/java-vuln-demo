package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class C3s { public void run(HttpServletRequest req, Connection cn) throws Exception {
  String p = req.getParameter("p");
  cn.createStatement().executeQuery("SELECT " + p);
}}
