package it.acsoftware.hyperiot.hproject.deserialization.model;

public class HPacketInfo {

    private long hProjectId;
    private long hDeviceId;
    private long hPacketId;
    private String name;
    private String type;
    private String trafficPlan;
    private boolean unixTimestamp;
    private boolean unixTimestampFormatSeconds;
    private HPacketSchema schema;
    private HPacketTimestamp timestamp;

    public long getHProjectId() {
        return hProjectId;
    }

    public void setHProjectId(long hProjectId) {
        this.hProjectId = hProjectId;
    }

    public long getHDeviceId() {
        return hDeviceId;
    }

    public void setHDeviceId(long hDeviceId) {
        this.hDeviceId = hDeviceId;
    }

    public long getHPacketId() {
        return hPacketId;
    }

    public void setHPacketId(long hPacketId) {
        this.hPacketId = hPacketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrafficPlan() {
        return trafficPlan;
    }

    public void setTrafficPlan(String trafficPlan) {
        this.trafficPlan = trafficPlan;
    }

    public HPacketSchema getSchema() {
        return schema;
    }

    public void setSchema(HPacketSchema schema) {
        this.schema = schema;
    }

    public HPacketTimestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(HPacketTimestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isUnixTimestamp() {
        return unixTimestamp;
    }

    public void setUnixTimestamp(boolean unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public boolean isUnixTimestampFormatSeconds() {
        return unixTimestampFormatSeconds;
    }

    public void setUnixTimestampFormatSeconds(boolean unixTimestampFormatSeconds) {
        this.unixTimestampFormatSeconds = unixTimestampFormatSeconds;
    }

    @Override
    public String toString() {
        return "HPacketInfo{" +
            "hProjectId=" + hProjectId +
            ", hDeviceId=" + hDeviceId +
            ", hPacketId=" + hPacketId +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            ", trafficPlan='" + trafficPlan + '\'' +
            ", unixTimestamp=" + unixTimestamp +
            ", unixTimestampFormatSeconds=" + unixTimestampFormatSeconds +
            ", schema=" + schema +
            ", timestamp=" + timestamp +
            '}';
    }
}
