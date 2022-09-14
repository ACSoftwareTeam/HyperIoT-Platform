package it.acsoftware.hyperiot.hpacket.model;

import java.util.Date;

public enum HPacketFieldType {
	OBJECT(Object.class), INTEGER(Integer.class), DOUBLE(Double.class), FLOAT(Float.class), BOOLEAN(Boolean.class), DATE(Date.class),
	TEXT(String.class), TIMESTAMP(Long.class), CATEGORY(String.class), TAG(String.class), BYTE(Byte.class);

	private Class<?> classType;

	HPacketFieldType(Class<?> classType) {
		this.classType = classType;
	}

	public Class<?> getClassType() {
		return classType;
	}
}
