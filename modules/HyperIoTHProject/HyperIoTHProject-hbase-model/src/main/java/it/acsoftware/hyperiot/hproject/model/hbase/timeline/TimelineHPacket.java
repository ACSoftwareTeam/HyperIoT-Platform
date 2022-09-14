package it.acsoftware.hyperiot.hproject.model.hbase.timeline;

import java.util.List;

@SuppressWarnings("unused")
public class TimelineHPacket {

    private List<TimelineHPacketField> fields;
    private String timestampField;

    public List<TimelineHPacketField> getFields() {
        return fields;
    }

    public void setFields(List<TimelineHPacketField> fields) {
        this.fields = fields;
    }

    public String getTimestampField() {
        return timestampField;
    }

    public void setTimestampField(String timestampField) {
        this.timestampField = timestampField;
    }

}
