<%-- IL-1 polyglot — SAFE mirror of interop_jsp_el.jsp.
     The request parameter is emitted via JSTL <c:out>, which HTML-escapes by
     default, so attacker markup is rendered as text. ZERO findings expected. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
  <h1>Search</h1>
  <%-- Safe: c:out escapeXml defaults to true → ${param.q} is HTML-escaped. --%>
  <p>Results for: <c:out value="${param.q}"/></p>
</body>
</html>
