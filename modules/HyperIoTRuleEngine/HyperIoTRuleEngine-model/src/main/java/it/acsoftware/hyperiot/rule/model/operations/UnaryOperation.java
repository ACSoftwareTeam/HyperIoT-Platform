package it.acsoftware.hyperiot.rule.model.operations;

/**
 *
 * @author Aristide Cittadino
 * Abstract type for binary operations
 */
public abstract class UnaryOperation extends AbstractOperation {

	/**
	 *
	 */
	@Override
	public void defineOperands(RuleNode... operands) {
		if (operands.length != 1)
			throw new RuntimeException("And operation must have exactly 2 operands");
		super.defineOperands(operands);
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
	public abstract String getDefinition();

	/**
	 * @return drools definition of the rule
	 */
	@Override
	public abstract String droolsDefinition();

}
