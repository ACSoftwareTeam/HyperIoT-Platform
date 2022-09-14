/*
 * Copyright (C) AC Software, S.r.l. - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Gene <generoso.martello@acsoftware.it>, March 2019
 *
 */
package it.acsoftware.hyperiot.stormmanager.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionName;

/**
 * 
 * @author Aristide Cittadino Model class that enumerate StormManager Actions
 *
 */
public enum HyperIoTStormManagerAction implements HyperIoTActionName {
	
	UPLOAD_TOPOLOGY_JAR("upload_topology_jar");

	private String name;

     /**
	 * Role Action with the specified name.
	 * 
	 * @param name parameter that represent the StormManager  action
	 */
	HyperIoTStormManagerAction(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of StormManager action
	 */
	public String getName() {
		return name;
	}

}
