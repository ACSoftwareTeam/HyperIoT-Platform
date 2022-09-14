package it.acsoftware.hyperiot.alarm.service.actions;

import it.acsoftware.hyperiot.rule.model.RuleType;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;

public abstract class AlarmAction extends RuleAction {

    private String alarmName;
    private String deviceName;
    private long alarmId;
    private int severity;
    private final RuleType ruleType = RuleType.ALARM_EVENT;

    public long getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(long alarmId) {
        this.alarmId = alarmId;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public RuleType getRuleType() {
        return ruleType;
    }

    @Override
    public boolean executeAsSoonAsUnmetCondition() {
        return true;
    }

}
