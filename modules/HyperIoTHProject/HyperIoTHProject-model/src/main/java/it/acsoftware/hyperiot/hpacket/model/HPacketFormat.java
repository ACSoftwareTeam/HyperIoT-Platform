package it.acsoftware.hyperiot.hpacket.model;

public enum HPacketFormat {
	JSON("json"), XML("xml"), CSV("csv"),TEXT("text");;

	private String name;

	HPacketFormat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
