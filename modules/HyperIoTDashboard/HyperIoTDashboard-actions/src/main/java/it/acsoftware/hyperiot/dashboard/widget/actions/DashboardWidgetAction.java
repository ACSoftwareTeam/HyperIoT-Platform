package it.acsoftware.hyperiot.dashboard.widget.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate DashboardWidget Actions
 *
 */
public enum DashboardWidgetAction implements HyperIoTActionName {
	
	//TO DO: add enumerations here
	ACTION_ENUM("action_enum");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the DashboardWidget  action
	 */
	private DashboardWidgetAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of DashboardWidget action
	 */
	public String getName() {
		return name;
	}

}
