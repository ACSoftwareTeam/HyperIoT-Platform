package it.acsoftware.hyperiot.widget.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate Widget Actions
 *
 */
public enum WidgetAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_ENUM("action_enum");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the Widget  action
	 */
	private WidgetAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of Widget action
	 */
	public String getName() {
		return name;
	}

}
