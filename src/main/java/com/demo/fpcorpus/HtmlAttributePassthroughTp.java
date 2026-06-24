// TP (CWE-79 / cognium-dev#153) — user input reflected into an HTML *attribute* context
// without attribute-encoding (missing-sanitizer-gate; xwiki CVE-2023-37908 shape).
package com.demo.fpcorpus;
public class HtmlAttributePassthroughTp {
    public String link(String url) {
        return "<a href=\"" + url + "\">click</a>"; // SINK (CWE-79 attribute context)
    }
}
