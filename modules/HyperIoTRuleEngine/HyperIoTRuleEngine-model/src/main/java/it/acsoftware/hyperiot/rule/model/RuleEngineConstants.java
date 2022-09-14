package it.acsoftware.hyperiot.rule.model;

public final class RuleEngineConstants {

	private RuleEngineConstants() {
		throw new IllegalStateException("Utility class");
	}

	public static final String RULE_ENGINE_EVENTS_THREAD_CORE = "it.acsoftware.hyperiot.rule.engine.events.threads.core";
	public static final String RULE_ENGINE_EVENTS_THREAD_MAXIMUM = "it.acsoftware.hyperiot.rule.engine.events.threads.maximum";
	public static final String RULE_ENGINE_EVENTS_THREAD_IDLE_KEEP_ALIVE = "it.acsoftware.hyperiot.rule.engine.events.threads.idleKeepAlive.minutes";
}
