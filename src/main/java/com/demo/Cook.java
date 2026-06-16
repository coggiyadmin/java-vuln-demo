package com.demo;
import javax.servlet.http.*;
public class Cook { public void set(HttpServletResponse resp){
  Cookie c = new Cookie("session","abc"); resp.addCookie(c);  // no setSecure/setHttpOnly -> CWE-614
}}
