package com.demo.variants.sqli;

import org.apache.ibatis.annotations.Select;
import javax.servlet.http.HttpServletRequest;
public interface V80MybatisDollar {
    // MyBatis ${} interpolates raw (unlike #{} bind) — SQL injection.
    @Select("SELECT * FROM users WHERE name = '${name}'") // SINK CWE-89 MyBatis ${}
    Object findByName(String name);
}
