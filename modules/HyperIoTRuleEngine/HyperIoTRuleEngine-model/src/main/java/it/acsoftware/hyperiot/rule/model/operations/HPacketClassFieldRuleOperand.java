package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino 
 * Operand for retrieving a packet field value by getter methods of HPacket class
 */
public class HPacketClassFieldRuleOperand extends AbstractOperation implements RuleNode {
	private String value;

	/**
	 * 
	 * @param value
	 */
	public HPacketClassFieldRuleOperand(String value) {
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
		return value.substring(0,1).toUpperCase()+value.substring(1);
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
		return "packet.get"+this.getDefinition() + "()";
	}
}
