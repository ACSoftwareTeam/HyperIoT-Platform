package it.acsoftware.hyperiot.rule.model.operations;

import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Abstract rule operation which maps every possibile
 *         operation expression
 */
public abstract class AbstractOperation implements RuleOperation, RuleNode {

	protected List<RuleNode> operands;

	public AbstractOperation() {
		super();
		this.operands = new ArrayList<>();
	}


	/**
	 * Define operation operands
	 */
	@Override
	public void defineOperands(RuleNode... operands) {
		if (operands.length > this.numOperands())
			throw new HyperIoTRuntimeException("Too much operands for operation!");
		this.operands.addAll(Arrays.asList(operands));
	}

	/**
	 * Boolean which says if the current operation expects a single value or an
	 * expression
	 */
	@Override
	public boolean needsExpr() {
		return false;
	}

	/**
	 * return the string rappresentaion of the rule
	 */
	@Override
	public abstract String getDefinition();

}
