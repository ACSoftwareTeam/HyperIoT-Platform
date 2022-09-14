package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Aristide Cittadino
 * Not equal to operation
 */
@Component(service = RuleOperation.class)
public class NotEqualTo extends BinaryOperation implements RuleNode {

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return "NotEqualTo (!=)";
	}

	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return "!=";
	}
	
}
