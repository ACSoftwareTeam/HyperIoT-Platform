package it.acsoftware.hyperiot.rule.model.operations;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aristide Cittadino
 * Rule Node which maps parenthesis concept
 */
public class ParenthesisNode implements RuleNode {
	private List<RuleNode> operands;

	@Override
	public void defineOperands(RuleNode... operands) {
		this.operands = Arrays.asList(operands);
	}

	/**
	 * return the string rappresentaion of the rule
	 */
	@Override
	public String getDefinition() {
		return "( " + this.operands.get(0).getDefinition() + " )";
	}

	@Override
	public String droolsDefinition() {
		return "( " + this.operands.get(0).droolsDefinition() + " )";
	}

}
