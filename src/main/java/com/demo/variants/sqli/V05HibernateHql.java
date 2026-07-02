package com.demo.variants.sqli;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;

public class V05HibernateHql {
    public void hql(HttpServletRequest req, Session session) {
        String name = req.getParameter("name");
        session.createQuery("FROM User u WHERE u.name = '" + name + "'").list(); // SINK CWE-89
    }
}
