package com.demo.variants.xpath;

import net.sf.saxon.s9api.*;
import javax.servlet.http.HttpServletRequest;
public class V03SaxonLibrary {
    public void saxon(HttpServletRequest req) throws Exception {
        String name = req.getParameter("name");
        new Processor(false).newXPathCompiler().compile("//user[@name='" + name + "']").load(); // SINK CWE-643
    }
}
