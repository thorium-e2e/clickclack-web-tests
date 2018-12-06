package com.clickclack.models;

import java.util.HashMap;
import java.util.Map;

public class Clack {

    private Map<String, String> attributes;

    public Clack(Map<String, String> attrs) {
        setAttributes(attrs);
    }

    public Clack() {
        setAttributes(new HashMap<String, String>());
    }

    private Map<String, String> getAttributes() {
        return attributes;
    }

    private void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String attrName) {
        return getAttributes().get(attrName);
    }

    public String getID() {
        return getAttribute("id");
    }
}
