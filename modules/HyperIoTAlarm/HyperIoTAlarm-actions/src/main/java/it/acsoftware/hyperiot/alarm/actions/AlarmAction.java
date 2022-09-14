package it.acsoftware.hyperiot.alarm.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate Alarm Actions
 *
 */
public enum AlarmAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_ENUM("action_enum");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the Alarm  action
	 */
	private AlarmAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of Alarm action
	 */
	public String getName() {
		return name;
	}

}
