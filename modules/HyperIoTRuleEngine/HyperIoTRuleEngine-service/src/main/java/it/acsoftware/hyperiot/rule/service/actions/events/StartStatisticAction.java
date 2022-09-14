package it.acsoftware.hyperiot.rule.service.actions.events;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import it.acsoftware.hyperiot.rule.model.RuleType;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;

/**
 *
 * @author Aristide Cittadino
 * Class which start statistics on HyperIoT Platform
 */
public class StartStatisticAction extends RuleAction implements Runnable {
	private static Logger log = LoggerFactory.getLogger(StartStatisticAction.class.getName());

	@Override
	public String droolsDefinition(String packetVariable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuleType getRuleType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void run() {
		// TODO: not implemented yet
		log.debug( "Starting StartStatisticAction Action ....");
	}

}
