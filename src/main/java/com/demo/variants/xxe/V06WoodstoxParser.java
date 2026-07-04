package com.demo.variants.xxe;

import com.ctc.wstx.stax.WstxInputFactory;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
public class V06WoodstoxParser {
    public void woodstox(HttpServletRequest req) throws Exception {
        byte[] xml = req.getInputStream().readAllBytes(); // SOURCE
        new WstxInputFactory().createXMLStreamReader(new ByteArrayInputStream(xml)); // SINK CWE-611
    }
}
