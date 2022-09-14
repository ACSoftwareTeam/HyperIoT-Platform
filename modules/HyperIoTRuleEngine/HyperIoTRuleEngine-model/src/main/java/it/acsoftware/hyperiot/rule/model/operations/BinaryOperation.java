package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino
 * Abstract type for binary operations
 */
public abstract class BinaryOperation extends AbstractOperation {

	/**
	 * 
	 */
	@Override
	public void defineOperands(RuleNode... operands) {
		if (operands.length != 2)
			throw new RuntimeException("And operation must have exactly 2 operands");
		super.defineOperands(operands);
	}
	
	/**
	 * 
	 */
	@Override
	public int numOperands() {
		return 2;
	}

	/**
	 * 
	 */
	@Override
	public String getDefinition() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.operands.get(0).getDefinition()).append(this.operator())
				.append(this.operands.get(1).getDefinition());
		return sb.toString();
	}

	/**
	 * @return drools definition of the rule
	 */
	@Override
	public String droolsDefinition() {
		StringBuilder sb = new StringBuilder();
		return sb.append("eval(").append(operands.get(0).droolsDefinition()).append(" ")
				.append(this.operator()).append(" ").append(operands.get(1).droolsDefinition())
				.append(")").toString();
	}

}
