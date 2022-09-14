package it.acsoftware.hyperiot.hproject.serialization.service;


import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.serialization.api.HPacketSerializer;

import java.io.IOException;

/**
 * Author Aristide Cittadino
 * Class implementing Plain Text HPacket serializer
 */
public class PlainTextHPacketSerializer implements HPacketSerializer {
    private static PlainTextHPacketSerializer instance;
    private JavaPropsMapper mapper;

    private PlainTextHPacketSerializer() {
        this.mapper = new JavaPropsMapper();
    }

    public static synchronized PlainTextHPacketSerializer getInstance() {
        if (instance == null)
            instance = new PlainTextHPacketSerializer();
        return instance;
    }

    @Override
    public byte[] serialize(HPacket hPacket) throws IOException {
        //text is just an alias for csv
        if (hPacket != null)
            return this.mapper.writeValueAsBytes(hPacket);
        return new byte[]{};
    }

    @Override
    public byte[] serializeRaw(HPacket hPacket) throws IOException {
        //text is just an alias for csv
        if (hPacket != null)
            return this.mapper.writeValueAsBytes(hPacket.getFlatFieldsMapWithValues());
        return new byte[]{};
    }
}
