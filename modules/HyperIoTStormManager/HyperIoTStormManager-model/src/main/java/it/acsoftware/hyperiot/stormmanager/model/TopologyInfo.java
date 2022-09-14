package it.acsoftware.hyperiot.stormmanager.model;

/**
 * Model for Storm TopologyInfo
 */
public class TopologyInfo {
    public static final String TOPOLOGY_STATUS_ACTIVE = "ACTIVE";

    private String status;
    private int uptimeSecs;
    private boolean mustResubmit;
    private int boltsCount;
    private int spoutsCount;

    public TopologyInfo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUptimeSecs() {
        return uptimeSecs;
    }

    public void setUptimeSecs(int uptimeSecs) {
        this.uptimeSecs = uptimeSecs;
    }

    public boolean isMustResubmit() {
        return mustResubmit;
    }

    public void setMustResubmit(boolean mustResubmit) {
        this.mustResubmit = mustResubmit;
    }

    public int getBoltsCount() {
        return boltsCount;
    }

    public void setBoltsCount(int boltsCount) {
        this.boltsCount = boltsCount;
    }

    public int getSpoutsCount() {
        return spoutsCount;
    }

    public void setSpoutsCount(int spoutsCount) {
        this.spoutsCount = spoutsCount;
    }
}
