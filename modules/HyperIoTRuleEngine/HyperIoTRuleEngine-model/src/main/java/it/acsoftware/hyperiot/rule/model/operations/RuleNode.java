package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino
 * Node of the expression
 */
public interface RuleNode {
	void defineOperands(RuleNode... operands);
	String getDefinition();
	String droolsDefinition();
}
