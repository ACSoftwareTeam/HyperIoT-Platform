package it.acsoftware.hyperiot.storm.alarm;

/**
 * This class map a hbase cell
 */
public class HBaseAlarmCell {

    private String alarmName;
    private long timestamp;
    private boolean inhibited;
    private int severity;
    private AlarmState state;

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isInhibited() {
        return inhibited;
    }

    public void setInhibited(boolean inhibited) {
        this.inhibited = inhibited;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public AlarmState getState() {
        return state;
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

}
