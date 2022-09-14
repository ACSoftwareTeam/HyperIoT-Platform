package it.acsoftware.hyperiot.rule.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;
import it.acsoftware.hyperiot.rule.model.Rule;
import it.acsoftware.hyperiot.rule.model.RuleType;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;

import java.util.Collection;
import java.util.List;

/**
 * @author Aristide Cittadino Interface component for RuleEngineApi. This interface
 * defines methods for additional operations.
 */
public interface RuleEngineApi extends HyperIoTBaseEntityApi<Rule> {
    String getDroolsForProject(HyperIoTContext context, long projectId, RuleType ruleType);
    List<RuleAction> findRuleActions(String type);
    /**
     * Finds all rules defined in a given project.
     *
     * @param context The HyperIoT context instance
     * @param packetId The packet id
     * @return List of rules
     */
    Collection<Rule> findAllRuleByPacketId(HyperIoTContext context, long packetId);
    Collection<Rule> findAllRuleByProjectId(HyperIoTContext context, long projectId);
}