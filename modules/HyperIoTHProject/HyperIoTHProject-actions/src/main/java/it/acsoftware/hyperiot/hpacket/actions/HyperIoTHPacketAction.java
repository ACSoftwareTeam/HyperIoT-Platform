package it.acsoftware.hyperiot.hpacket.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate HPacket Actions
 *
 */
public enum HyperIoTHPacketAction implements HyperIoTActionName {
	
	FIELDS_MANAGEMENT(Names.FIELDS_MANAGEMENT);

	private final String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the HPacket  action
	 */
	HyperIoTHPacketAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of HPacket action
	 */
	public String getName() {
		return name;
	}

	public static class Names {

		public static final String FIELDS_MANAGEMENT = "fields_management";

		private Names() {
			throw new IllegalStateException("Utility class");
		}

	}

}
