package it.acsoftware.hyperiot.hproject.serialization.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.serialization.api.HPacketSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Author Aristide Cittadino
 * writing HPacket as XML
 */
public class XmlHPacketSerializer implements HPacketSerializer {
    private static XmlHPacketSerializer instance;
    private XmlMapper xmlMapper;
    private ObjectMapper objectMapper;

    private XmlHPacketSerializer() {
        xmlMapper = new XmlMapper();
        objectMapper = new ObjectMapper();
    }

    public static synchronized XmlHPacketSerializer getInstance() {
        if (instance == null)
            instance = new XmlHPacketSerializer();
        return instance;
    }

    @Override
    public byte[] serialize(HPacket hPacket) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        xmlMapper.writerFor(HPacket.class).writeValue(outputStream, hPacket);
        return outputStream.toByteArray();
    }

    @Override
    public byte[] serializeRaw(HPacket hPacket) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        xmlMapper.writerFor(HashMap.class).withRootName("Root").writeValue(outputStream, hPacket.getFlatFieldsMapWithValues());
        return outputStream.toByteArray();
    }

}
