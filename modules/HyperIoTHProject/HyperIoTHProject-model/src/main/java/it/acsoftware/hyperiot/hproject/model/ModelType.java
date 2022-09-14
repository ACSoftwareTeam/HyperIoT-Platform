package it.acsoftware.hyperiot.hproject.model;

import it.acsoftware.hyperiot.hpacket.model.HPacket;

/**
 * This enumeration supports timeline queries and scanning of HPackets and Events
 */
public enum ModelType {

    HPACKET(HPacket.class.getSimpleName()),
    EVENT("Event"),
    ERROR("Error"),
    ALARMEVENT("AlarmEvent");

    private final String simpleName;

    ModelType(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return simpleName;
    }

}
