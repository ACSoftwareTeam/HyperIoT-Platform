package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Aristide Cittadino And logic operation
 */
@Component(service = RuleOperation.class)
public class AndOperation extends BinaryOperation implements RuleNode {
	

	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return "AND";
	}

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return "And";
	}

	/**
	 * @return true if this operation needs an inner expression
	 */
	@Override
	public boolean needsExpr() {
		return true;
	}

	/**
	 * @return the drools definition of the logic condition
	 */
	@Override
	public String droolsDefinition() {
		return operands.get(0).droolsDefinition() +
				" && " +
				operands.get(1).droolsDefinition();
	}
}
