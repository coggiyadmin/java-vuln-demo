// FP-target (cognium-dev#166) — XML parser hardened with JDK entity limits + external-DTD
// disabled must not be flagged xml-entity-expansion / xxe.
package com.demo.fpcorpus;
import javax.xml.parsers.DocumentBuilderFactory;
public class SafeXmlHardened {
    public DocumentBuilderFactory factory() throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        f.setFeature("http://xml.org/sax/features/external-general-entities", false);
        f.setAttribute("http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", "0");
        return f; // hardened — NOT a sink
    }
}
