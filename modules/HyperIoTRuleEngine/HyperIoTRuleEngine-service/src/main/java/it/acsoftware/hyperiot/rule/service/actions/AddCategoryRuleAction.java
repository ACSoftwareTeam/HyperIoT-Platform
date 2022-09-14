package it.acsoftware.hyperiot.rule.service.actions;

import javax.persistence.DiscriminatorValue;

import it.acsoftware.hyperiot.rule.model.actions.EnrichmentRuleAction;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;
import org.osgi.service.component.annotations.Component;

import it.acsoftware.hyperiot.rule.model.RuleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Aristide Cittadino Add category action to categorize input data
 */
@Component(service = RuleAction.class, immediate = true,property = {"it.acsoftware.hyperiot.rule.action.type=ENRICHMENT"})
@DiscriminatorValue("rule.action.name.addCategory")
public class AddCategoryRuleAction extends EnrichmentRuleAction {
	private static Logger log = LoggerFactory.getLogger(AddCategoryRuleAction.class.getName());

	/**
	 * Category ids
	 */
	private long[] categoryIds;

	/**
	 *
	 */
	public AddCategoryRuleAction() {
		super();
	}

	/**
	 *
	 * @return category ids
	 */
	public long[] getCategoryIds() {
		return categoryIds;
	}

	/**
	 *
	 * @param categoryIds
	 */
	public void setCategoryIds(long[] categoryIds) {
		this.categoryIds = categoryIds;
	}

	/**
	 * @return the drools definition of the action
	 */
	@Override
	public String droolsDefinition(String packetVariable) {
		log.debug( "In AddCategoryRuleAction.droolsDefinition");
		StringBuilder sb = new StringBuilder();
		sb.append(packetVariable).append(".setCategoryIds(new long[]{");
		for (int i = 0; i < categoryIds.length; i++) {
			if (i > 0)
				sb.append(",");
			sb.append("(long)").append(String.valueOf(categoryIds[i]));
		}
		sb.append("})");
		log.debug("partial Drool generated: {}", sb);
		return sb.toString();
	}



}
