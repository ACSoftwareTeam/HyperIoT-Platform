package it.acsoftware.hyperiot.dashboard.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate Dashboard Actions
 *
 */
public enum HyperIoTDashboardAction implements HyperIoTActionName {
	
	FIND_WIDGETS(Names.FIND_WIDGETS);

	private final String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the Dashboard  action
	 */
	HyperIoTDashboardAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of Dashboard action
	 */
	public String getName() {
		return name;
	}

	public static class Names {

		public static final String FIND_WIDGETS = "find_widgets";

		private Names() {
			throw new IllegalStateException("Utility class");
		}

	}

}
