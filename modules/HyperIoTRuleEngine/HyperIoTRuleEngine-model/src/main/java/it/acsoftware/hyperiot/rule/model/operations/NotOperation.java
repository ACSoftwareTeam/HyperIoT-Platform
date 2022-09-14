package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Aristide Cittadino Not operator
 */
@Component(service = RuleOperation.class)
public class NotOperation extends AbstractOperation implements RuleNode, RuleOperator {

	@Override
	public void defineOperands(RuleNode... operands) {
		if (operands.length != 1)
			throw new RuntimeException("And operation must have exactly 1 operands");
		super.defineOperands(operands);
	}

	/**
	 * return the string rappresentaion of the rule
	 */
	@Override
	public String getDefinition() {
		StringBuilder sb = new StringBuilder();
		sb.append("NOT ").append(this.operands.get(0).getDefinition()).append("");
		return sb.toString();
	}

	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return "NOT";
	}

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return "Not";
	}

	@Override
	public boolean needsExpr() {
		return false;
	}

	/**
	 * returns the number of operands required by this operation
	 */
	@Override
	public int numOperands() {
		return 1;
	}

	@Override
	public String droolsDefinition() {
		return "eval(!(" + operands.get(0).droolsDefinition() + "))";
	}

}
