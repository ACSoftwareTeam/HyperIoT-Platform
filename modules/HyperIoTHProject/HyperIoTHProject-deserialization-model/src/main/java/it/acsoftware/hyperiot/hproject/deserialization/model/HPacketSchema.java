package it.acsoftware.hyperiot.hproject.deserialization.model;

import java.util.HashMap;

public class HPacketSchema {

    private String type;
    private HashMap<String, Object> fields;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }

}
