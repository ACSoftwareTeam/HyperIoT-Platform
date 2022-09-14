package it.acsoftware.hyperiot.rule.service.actions;

import it.acsoftware.hyperiot.rule.model.actions.EnrichmentRuleAction;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.persistence.DiscriminatorValue;

import org.osgi.service.component.annotations.Component;

import it.acsoftware.hyperiot.rule.model.RuleType;

/**
 *
 * @author Aristide Cittadino Rule for validating HPacket
 */
@Component(service = RuleAction.class, immediate = true,property = {"it.acsoftware.hyperiot.rule.action.type=ENRICHMENT"})
@DiscriminatorValue("rule.action.name.validate")
public class ValidateHPacketRuleAction extends EnrichmentRuleAction {
	private static Logger log = LoggerFactory.getLogger(ValidateHPacketRuleAction.class.getName());

	public ValidateHPacketRuleAction() {
		super();
	}

	@Override
	public String droolsDefinition(String packetVariable) {
		log.debug( "In ValidateHPacketRuleAction.droolsDefinition");
		return packetVariable + ".setValid(true);";
	}

}
