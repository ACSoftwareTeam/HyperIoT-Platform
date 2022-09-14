package it.acsoftware.hyperiot.hpacket.model;

public enum HPacketFieldMultiplicity {
	SINGLE("single"), ARRAY("array"), MATRIX("matrix");

	private String name;

	HPacketFieldMultiplicity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
