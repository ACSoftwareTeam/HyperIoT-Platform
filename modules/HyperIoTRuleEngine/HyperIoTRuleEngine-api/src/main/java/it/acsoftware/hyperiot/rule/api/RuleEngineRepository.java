package it.acsoftware.hyperiot.rule.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.rule.model.Rule;
import it.acsoftware.hyperiot.rule.model.RuleType;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for RuleEngine Repository. It
 *         is used for CRUD operations, and to interact with the persistence
 *         layer.
 *
 */
public interface RuleEngineRepository extends HyperIoTBaseRepository<Rule> {

    Collection<Rule> getDroolsForProject(long projectId, RuleType ruleType);

    Collection<Rule> findAllRuleByPacketId(long packetId);

    Collection<Rule> findAllRuleByProjectId(long projectId);

    Collection<Rule> findAllRuleByProjectIdAndRuleType(long projectId , RuleType ruleType );

    Collection<Rule> findAllRuleByHPacketId(long hPacketId );

    Collection<Rule> findAllRuleByHPacketFieldId(long hPacketFieldId );

}
