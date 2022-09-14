package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Aristide Cittadino
 * Greater than operation
 */
@Component(service = RuleOperation.class)
public class GreaterThan extends BinaryOperation implements RuleNode {

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return "GreaterThan (>)";
	}

	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return ">";
	}
	
}
