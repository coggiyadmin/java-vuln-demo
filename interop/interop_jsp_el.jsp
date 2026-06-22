<%-- IL-1 polyglot — Java/JSP → Expression Language (CWE-79).
     Host (JSP/servlet container) embeds EL; the request parameter is written
     into the HTML response unescaped, so attacker markup executes (reflected XSS).
     Expected today: likely FN (JSP/EL template sink not modeled). --%>
<html>
<body>
  <h1>Search</h1>
  <%-- SINK (CWE-79): ${param.q} is emitted unescaped into the HTML body. --%>
  <p>Results for: ${param.q}</p>
</body>
</html>
