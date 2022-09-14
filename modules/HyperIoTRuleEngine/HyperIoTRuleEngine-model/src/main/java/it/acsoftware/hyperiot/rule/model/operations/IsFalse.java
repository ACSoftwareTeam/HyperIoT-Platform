package it.acsoftware.hyperiot.rule.model.operations;

import org.osgi.service.component.annotations.Component;

/**
 * @author Aristide Cittadino Equal to operation
 */
@Component(service = RuleOperation.class)
public class IsFalse extends UnaryOperation implements RuleNode {

    /**
     * Returns the operation name
     */
    @Override
    public String getName() {
        return "isFalse (isFalse)";
    }

    /**
     * returns the token string which identifies the operation
     */
    @Override
    public String operator() {
        return "isTrue";
    }

    @Override
    public String getDefinition() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.operands.get(0).getDefinition()).append("== false");
        return sb.toString();
    }

    @Override
    public String droolsDefinition() {
        StringBuilder sb = new StringBuilder();
        return sb.append("eval(").append(operands.get(0).droolsDefinition()).append(" ")
            .append("==").append(" false")
            .append(")").toString();
    }
}
