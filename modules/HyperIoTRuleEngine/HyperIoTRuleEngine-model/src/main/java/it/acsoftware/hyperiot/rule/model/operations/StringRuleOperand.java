package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino String Operand
 */
public class StringRuleOperand extends AbstractOperation implements RuleNode {
	private String value;

	/**
	 * 
	 * @param value
	 */
	public StringRuleOperand(String value) {
		super();
		this.value = value;
	}

	/**
	 * 
	 */
	@Override
	public String getName() {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String operator() {
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String getDefinition() {
		return value;
	}

	/**
	 * 
	 */
	@Override
	public int numOperands() {
		return 1;
	}

	/**
	 * 
	 */
	@Override
	public String droolsDefinition() {
		return this.getDefinition();
	}
}
