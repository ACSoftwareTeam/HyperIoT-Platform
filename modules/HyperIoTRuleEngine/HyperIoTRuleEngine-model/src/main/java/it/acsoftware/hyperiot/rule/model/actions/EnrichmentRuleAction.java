package it.acsoftware.hyperiot.rule.model.actions;

import it.acsoftware.hyperiot.rule.model.RuleType;

public abstract class EnrichmentRuleAction extends RuleAction{

    protected static final RuleType ruleType = RuleType.ENRICHMENT;

    @Override
    public final RuleType getRuleType() {
        return ruleType;
    }
}
