package it.acsoftware.hyperiot.hproject.serialization.api;

import it.acsoftware.hyperiot.hpacket.model.HPacket;

import java.io.IOException;

public interface HPacketSerializer {

    /**
     * Serializes HPacket
     * @param hPacket
     * @return
     * @throws IOException
     */
    byte[] serialize(HPacket hPacket) throws IOException;

    /**
     * Serializes only packet fields no meta information.
     * It can be used for output packets going outside HyperIoT World
     * @param hPacket
     * @return
     * @throws IOException
     */
    byte[] serializeRaw(HPacket hPacket) throws IOException;

}
