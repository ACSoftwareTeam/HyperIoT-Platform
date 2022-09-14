package it.acsoftware.hyperiot.rule.model.actions;

import it.acsoftware.hyperiot.rule.model.RuleType;

public abstract class EventRuleAction extends RuleAction{

    protected static final RuleType ruleType = RuleType.EVENT;

    @Override
    public final RuleType getRuleType() {
        return ruleType;
    }

    @Override
    public final boolean executeAsSoonAsUnmetCondition() {
        return false;
    }
}
