package it.acsoftware.hyperiot.hproject.algorithm.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate HProjectAlgorithm Actions
 *
 */
public enum HProjectAlgorithmAction implements HyperIoTActionName {
	
	UPDATE_CONFIG(Names.UPDATE_CONFIG);

	private final String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the HProjectAlgorithm  action
	 */
	HProjectAlgorithmAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of HProjectAlgorithm action
	 */
	public String getName() {
		return name;
	}

	public static class Names {

		public static final String UPDATE_CONFIG = "update_config";

		private Names() {
			throw new IllegalStateException("Utility class");
		}

	}

}
