// Framework-idiom benign (WS-5.2) — JPA criteria with a bound parameter that LOOKS
// like query building but is safe. ZERO security findings expected.
package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

public class SafeFrameworkOrm {
    public Object findUser(HttpServletRequest req, EntityManager em) {
        String name = req.getParameter("name");
        // JPQL with a named bound parameter — not string-concatenated.
        TypedQuery<Object> q = em.createQuery("SELECT u FROM User u WHERE u.name = :n", Object.class);
        q.setParameter("n", name);
        return q.getResultList();
    }
}
