package com.demo.variants.deserialization;

import org.bson.BsonBinaryReader;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import javax.servlet.http.HttpServletRequest;
public class V04BsonLibrary {
    public void bson(HttpServletRequest req) throws Exception {
        byte[] b = req.getParameter("s").getBytes();
        new DocumentCodec().decode(new BsonBinaryReader(b), DecoderContext.builder().build()); // SINK CWE-502
    }
}
