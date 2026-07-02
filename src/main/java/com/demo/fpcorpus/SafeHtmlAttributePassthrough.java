// Safe mirror (cognium-dev#153) — attribute context encoded before href reflection.
package com.demo.fpcorpus;

import org.apache.commons.text.StringEscapeUtils;

public class SafeHtmlAttributePassthrough {
    public String link(String url) {
        return "<a href=\"" + StringEscapeUtils.escapeHtml4(url) + "\">click</a>";
    }
}
