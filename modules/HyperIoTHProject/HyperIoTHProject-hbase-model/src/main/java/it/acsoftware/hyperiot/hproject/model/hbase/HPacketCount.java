package it.acsoftware.hyperiot.hproject.model.hbase;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class supports queries for timeline.
 * Given a lower bound timestamp and an upper bound one, it contains the following information:
 * - total number of HPacket instances registered between the timestamps;
 * - the first "delta" instances encountered between the timestamps, where delta refers to pagination delta, and
 *   it must be lower than HBase max scan page size;
 * - the first and last timestamps delimiting the retrieved page, so the client can request the following page,
 *   having the next timestamp (last timestamp of previous page)
 */
@SuppressWarnings("unused")
public class HPacketCount {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long hPacketId;
    private long totalCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long hDeviceId;

    public HPacketCount() {
        totalCount = 0L;
    }

    public Long getHPacketId() {
        return hPacketId;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setHPacketId(Long hPacketId) {
        this.hPacketId = hPacketId;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Long gethDeviceId() {
        return hDeviceId;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void sethDeviceId(Long hDeviceId) {
        this.hDeviceId = hDeviceId;
    }
}
