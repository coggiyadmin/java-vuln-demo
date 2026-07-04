package com.demo.taint.channels;
import org.apache.commons.text.StringEscapeUtils;
public class SafeCH02_websocket {
  public String onMessage(String message) {
    return "<p>" + StringEscapeUtils.escapeHtml4(message) + "</p>";
  }
}
