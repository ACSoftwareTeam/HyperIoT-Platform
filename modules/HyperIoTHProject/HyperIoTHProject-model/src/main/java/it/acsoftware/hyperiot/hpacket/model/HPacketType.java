package it.acsoftware.hyperiot.hpacket.model;

public enum HPacketType {
	INPUT("input"), OUTPUT("output"), IO("io");

	private String name;

	HPacketType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
