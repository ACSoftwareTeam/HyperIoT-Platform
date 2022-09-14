package it.acsoftware.hyperiot.rule.model.operations;

/**
 * 
 * @author Aristide Cittadino
 * Class for retrieving values from the concrete packet (nested fileds declared by the user)
 */
public class HPacketFieldRuleOperand extends AbstractOperation implements RuleNode {
	private String value;
	/**
	 * Rules are multi packet, so each HPacketField needs to be related to its HPacket
	 */
	private long hPacketId;

	/**
	 * 
	 * @param value
	 */
	public HPacketFieldRuleOperand(String value, long id) {
		super();
		this.value = value;
		this.hPacketId = id;
	}

	public long getHPacketId() {
		return hPacketId;
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
		return "packet_" + getHPacketId() + ".getFieldValue(\"" + this.getDefinition() + "\")";
	}
}
