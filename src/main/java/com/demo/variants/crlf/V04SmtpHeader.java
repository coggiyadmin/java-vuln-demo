package com.demo.variants.crlf;

import javax.mail.*;
import javax.servlet.http.HttpServletRequest;
public class V04SmtpHeader {
    public void smtp(HttpServletRequest req) throws Exception {
        String to = req.getParameter("to");
        Message msg = new MimeMessage(Session.getInstance(new java.util.Properties()));
        msg.setRecipients(Message.RecipientType.TO, to); // SINK CWE-93 header injection
        Transport.send(msg);
    }
}
