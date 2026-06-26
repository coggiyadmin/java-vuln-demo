package com.demo.flow.tier1.deserialization;
import java.io.*;
import javax.servlet.http.*;
public class V08WrongContextTp {
    public void load(HttpServletRequest req) throws Exception {
        new ObjectInputStream(req.getInputStream()).readObject();
    }
}
