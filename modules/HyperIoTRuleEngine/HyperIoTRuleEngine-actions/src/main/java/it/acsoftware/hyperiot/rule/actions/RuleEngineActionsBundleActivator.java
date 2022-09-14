package it.acsoftware.hyperiot.rule.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;
import it.acsoftware.hyperiot.rule.model.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Model class that define a bundle activator and
 *         register actions for RuleEngine
 *
 */
public class RuleEngineActionsBundleActivator extends HyperIoTPermissionActivator {

	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		getLog().info("Registering Rule actions...");
		List<HyperIoTActionList> actionList = new ArrayList<>();
		HyperIoTActionList ruleActionList = HyperIoTActionFactory
				.createBaseCrudActionList(Rule.class.getName(), Rule.class.getName());
		ruleActionList.addAction(
				HyperIoTActionFactory.createAction(Rule.class.getName(),
						Rule.class.getName(), HyperIoTRuleEngineAction.ACTION_RUN)
		);
		actionList.add(ruleActionList);
		return actionList;
	}

}
