package it.acsoftware.hyperiot.kit.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate Kit Actions
 *
 */
public enum KitAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_ENUM("action_enum");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the Kit  action
	 */
	private KitAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of Kit action
	 */
	public String getName() {
		return name;
	}

}
