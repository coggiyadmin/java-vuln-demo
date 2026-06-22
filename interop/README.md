# interop/ — in-language polyglot (Java)

In-language cross-language fixtures (host=Java embeds a guest DSL). Cross-binary cases live in
`coggiyadmin/interop-vuln-demo`. Plan:
`cogniumhq/sast-validation/research/cross-language-interop-plan.md` (IL-1).

Each ships TP + `Safe*` + `benign_*`.

| Fixture | Boundary | CWE | Expected |
|---------|----------|-----|----------|
| `InteropThymeleaf.java` / `interop_thymeleaf.html` | Java → Thymeleaf unescaped EL | 79 | FN |
| `interop_jsp.jsp` | Java → JSP `${param.x}` unescaped | 79 | FN |
| `InteropSqlInString.java` | Java → SQL DSL in string → `Statement` | 89 | partial |
| `InteropShellInString.java` | Java → shell snippet → `Runtime.exec` | 78 | partial |
