package it.acsoftware.hyperiot.hdevice.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate HDevice Actions
 *
 */
public enum HyperIoTHDeviceAction implements HyperIoTActionName {
	
	PACKETS_MANAGEMENT(Names.PACKETS_MANAGEMENT);

	private final String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the HDevice  action
	 */
	HyperIoTHDeviceAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of HDevice action
	 */
	public String getName() {
		return name;
	}

	public static class Names {

		public static final String PACKETS_MANAGEMENT = "packets_management";

		private Names() {
			throw new IllegalStateException("Utility class");
		}

	}

}
