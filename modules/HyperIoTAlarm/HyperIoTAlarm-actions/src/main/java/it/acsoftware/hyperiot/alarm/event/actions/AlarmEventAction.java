package it.acsoftware.hyperiot.alarm.event.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate AlarmEvent Actions
 *
 */
public enum AlarmEventAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_ENUM("action_enum");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the AlarmEvent  action
	 */
	private AlarmEventAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of AlarmEvent action
	 */
	public String getName() {
		return name;
	}

}
