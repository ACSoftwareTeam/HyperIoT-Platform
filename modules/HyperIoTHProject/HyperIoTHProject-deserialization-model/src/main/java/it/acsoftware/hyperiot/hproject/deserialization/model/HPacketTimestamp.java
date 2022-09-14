package it.acsoftware.hyperiot.hproject.deserialization.model;

public class HPacketTimestamp {

    private String format;
    private String field;
    private boolean createDefaultIfNotExists;

    public HPacketTimestamp() {
        this.createDefaultIfNotExists = true;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isCreateDefaultIfNotExists() {
        return createDefaultIfNotExists;
    }

    public void setCreateDefaultIfNotExists(boolean createDefaultIfNotExists) {
        this.createDefaultIfNotExists = createDefaultIfNotExists;
    }
}
