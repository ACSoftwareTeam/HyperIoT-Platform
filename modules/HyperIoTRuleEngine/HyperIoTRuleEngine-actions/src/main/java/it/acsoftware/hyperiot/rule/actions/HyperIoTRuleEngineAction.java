package it.acsoftware.hyperiot.rule.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate RuleEngine Actions
 *
 */
public enum HyperIoTRuleEngineAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_RUN("action_run");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the RuleEngine  action
	 */
	private HyperIoTRuleEngineAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of RuleEngine action
	 */
	public String getName() {
		return name;
	}

}
