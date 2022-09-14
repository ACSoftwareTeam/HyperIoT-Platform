package it.acsoftware.hyperiot.rule.model.facts;

public class FiredRule {

    private long ruleId;
    private boolean fired;

    public FiredRule() {
    }

    public FiredRule(long ruleId, boolean fired) {
        this.ruleId = ruleId;
        this.fired = fired;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public boolean isFired() {
        return fired;
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }
}
