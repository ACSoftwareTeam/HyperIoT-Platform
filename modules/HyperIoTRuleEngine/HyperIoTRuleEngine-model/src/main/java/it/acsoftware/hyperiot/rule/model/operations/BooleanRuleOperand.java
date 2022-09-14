package it.acsoftware.hyperiot.rule.model.operations;

/**
 * @author Aristide Cittadino String Operand
 */
public class BooleanRuleOperand extends AbstractOperation implements RuleNode {
    private Boolean value;

    /**
     * @param value
     */
    public BooleanRuleOperand(Boolean value) {
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
        return String.valueOf(value);
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
