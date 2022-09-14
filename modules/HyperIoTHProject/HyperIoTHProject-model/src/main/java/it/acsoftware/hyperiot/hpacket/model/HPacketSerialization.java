package it.acsoftware.hyperiot.hpacket.model;

public enum HPacketSerialization {
	AVRO("avro"), NONE("none");

	private String name;

	HPacketSerialization(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
