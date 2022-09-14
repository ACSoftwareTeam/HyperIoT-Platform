package it.acsoftware.hyperiot.hproject.model.hbase.timeline;

/**
 * This class supports timeline queries.
 * timestamp property contains a time value when there were HPacket events.
 * Event number is storing to count variable.
 */
@SuppressWarnings("unused")
public class TimelineElement {

    private long timestamp;
    private long count;

    public TimelineElement(long timestamp, long count) {
        this.timestamp = timestamp;
        this.count = count;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
