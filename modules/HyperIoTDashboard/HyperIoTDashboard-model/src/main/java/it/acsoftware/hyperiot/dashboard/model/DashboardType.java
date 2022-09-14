package it.acsoftware.hyperiot.dashboard.model;

/**
 * 
 * @author Aristide Cittadino
 * Dashboard types
 */
public enum DashboardType {

	OFFLINE("OFFLINE"), REALTIME("REALTIME");
	
	private String type;
	
	private DashboardType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
