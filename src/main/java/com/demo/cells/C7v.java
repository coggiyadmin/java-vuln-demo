package com.demo.cells;
import java.sql.*; import javax.servlet.http.HttpServletRequest;
public class C7v { public String run(HttpServletRequest req, Connection cn) throws Exception {
    String raw=req.getParameter("u"); String u=raw; Runtime.getRuntime().exec("echo "+u);
 return ""; } }
