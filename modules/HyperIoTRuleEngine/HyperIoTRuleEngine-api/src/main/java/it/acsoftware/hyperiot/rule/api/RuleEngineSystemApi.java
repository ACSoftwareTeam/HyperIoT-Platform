package it.acsoftware.hyperiot.rule.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;
import it.acsoftware.hyperiot.rule.model.Rule;
import it.acsoftware.hyperiot.rule.model.RuleType;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface RuleEngineSystemApi extends HyperIoTBaseEntitySystemApi<Rule> {
	String getDroolsForProject(long projectId, RuleType ruleType);
	/**
	 * Finds all rules defined in a given project.
	 *
	 * @param packetId The packet id
	 * @return List of rules
	 */
	Collection<Rule> findAllRuleByPacketId(long packetId);
	Collection<Rule> findAllRuleByProjectId(long projectId);

	void removeByHPacketId(long hPacketId);

	void removeByHProjectId(long hProjectId);

	Collection<Rule> findAllRuleByProjectIdAndRuleType(long projectId , RuleType ruleType );


	Collection<Rule> findAllRuleByHPacketId(long hPacketId );

	Collection<Rule> findAllRuleByHPacketFieldId(long hPacketFieldId );
}