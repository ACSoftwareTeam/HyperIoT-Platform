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
 * @author Aristide Cittadino
 * Add category action to categorize input data
 */
@Component(service = RuleAction.class, immediate = true,property = {"it.acsoftware.hyperiot.rule.action.type=ENRICHMENT"})
@DiscriminatorValue("rule.action.name.addTag")
public class AddTagRuleAction extends EnrichmentRuleAction {
	private static Logger log = LoggerFactory.getLogger(AddTagRuleAction.class.getName());
	/**
	 * Tag ids
	 */
	private long[] tagIds;

	/**
	 *
	 */
	public AddTagRuleAction() {
		super();
	}

	/**
	 *
	 * @return tag ids
	 */
	public long[] getTagIds() {
		return tagIds;
	}

	/**
	 *
	 * @param tagIds
	 */
	public void setTagIds(long[] tagIds) {
		this.tagIds = tagIds;
	}

	/**
	 * @return the drools definition of the action
	 */
	@Override
	public String droolsDefinition(String packetVariable) {
		log.debug( "In AddCategoryRuleAction.droolsDefinition");
		StringBuilder sb = new StringBuilder();
		sb.append(packetVariable).append(".setTagIds(new long[]{");
		for (int i = 0; i < tagIds.length; i++) {
			if (i > 0)
				sb.append(",");
			sb.append("(long)").append(tagIds[i]);
		}
		sb.append("})");
		log.debug( "partial Drool generated: {}",sb);
		return sb.toString();
	}

}
