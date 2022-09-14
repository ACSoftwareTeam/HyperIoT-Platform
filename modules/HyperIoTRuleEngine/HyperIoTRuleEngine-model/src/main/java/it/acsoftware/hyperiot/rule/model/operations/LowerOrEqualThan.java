package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Aristide Cittadino
 * Lower or equal than operation
 */
@Component(service = RuleOperation.class)
public class LowerOrEqualThan extends BinaryOperation implements RuleNode {

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return "LowerOrEqualThan (<=)";
	}

	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return "<=";
	}

}
