package it.acsoftware.hyperiot.area.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate Area Actions
 *
 */
public enum HyperIoTAreaAction implements HyperIoTActionName {
	
	AREA_DEVICE_MANAGER(Names.AREA_DEVICE_MANAGER);

	private final String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the Area  action
	 */
	HyperIoTAreaAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of Area action
	 */
	public String getName() {
		return name;
	}

	public static class Names {

		public static final String AREA_DEVICE_MANAGER = "area_device_manager";

		private Names() {
			throw new IllegalStateException("Utility class");
		}

	}

}
