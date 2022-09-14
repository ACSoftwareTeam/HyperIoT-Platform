package it.acsoftware.hyperiot.hproject.deserialization.api;

import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.deserialization.model.HPacketInfo;

import java.io.IOException;

public interface HPacketDeserializer {

    HPacket deserialize(byte[] rawHPacket, HPacketInfo hPacketInfo) throws IOException;

}
