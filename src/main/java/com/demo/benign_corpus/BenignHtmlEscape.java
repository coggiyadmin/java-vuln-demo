package com.demo.benign_corpus;

import org.apache.commons.text.StringEscapeUtils;

/** TN — HTML escape before output. */
public class BenignHtmlEscape {
    public String render(String name) {
        return "<p>" + StringEscapeUtils.escapeHtml4(name) + "</p>";
    }
}
