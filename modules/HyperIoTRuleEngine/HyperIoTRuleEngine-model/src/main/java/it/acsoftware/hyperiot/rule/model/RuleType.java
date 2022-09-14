package it.acsoftware.hyperiot.rule.model;

/**
 * 
 * @author Aristide Cittadino
 * Enumeration which identifies the rule type
 */
public enum RuleType {
	ENRICHMENT("it.acsoftware.hyperiot.rules.enrichments"),
	EVENT("it.acsoftware.hyperiot.rules.events"),
	ALARM_EVENT("it.acsoftware.hyperiot.rules.events");
	private String droolsPackage;

	private RuleType(String droolsPackage) {
		this.droolsPackage = droolsPackage;
	}

	public String getDroolsPackage() {
		return droolsPackage;
	}

}
