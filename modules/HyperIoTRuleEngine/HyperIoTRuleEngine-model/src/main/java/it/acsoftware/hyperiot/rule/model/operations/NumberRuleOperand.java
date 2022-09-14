package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino
 * Number operand
 */
public class NumberRuleOperand extends AbstractOperation implements RuleNode {

	private Number number;

	public NumberRuleOperand(Number number) {
		super();
		this.number = number;
	}

	/**
	 * return the string rappresentaion of the rule
	 */
	@Override
	public String getDefinition() {
		return number.toString();
	}
	
	/**
	 * returns the token string which identifies the operation
	 */
	@Override
	public String operator() {
		return null;
	}

	/**
	 * Returns the operation name
	 */
	@Override
	public String getName() {
		return null;
	}

	/**
	 * returns the number of operands required by this operation
	 */
	@Override
	public int numOperands() {
		return 0;
	}
	
	@Override
	public String droolsDefinition() {
		return number.toString();
	}
	
}
