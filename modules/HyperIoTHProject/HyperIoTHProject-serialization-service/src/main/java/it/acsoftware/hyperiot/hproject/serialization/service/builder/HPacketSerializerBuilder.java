package it.acsoftware.hyperiot.hproject.serialization.service.builder;

import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hpacket.model.HPacketFormat;
import it.acsoftware.hyperiot.hproject.serialization.api.HPacketSerializer;
import it.acsoftware.hyperiot.hproject.serialization.service.CsvHPacketSerializer;
import it.acsoftware.hyperiot.hproject.serialization.service.JsonHPacketSerializer;
import it.acsoftware.hyperiot.hproject.serialization.service.PlainTextHPacketSerializer;
import it.acsoftware.hyperiot.hproject.serialization.service.XmlHPacketSerializer;

import java.util.EnumMap;
import java.util.Map;

/**
 * Author Aristide Cittadino
 * returns correct serializer based on packet format
 */
public class HPacketSerializerBuilder {

    private static final Map<HPacketFormat, HPacketSerializer> serializerMap;

    static {
        serializerMap = new EnumMap<>(HPacketFormat.class);
        serializerMap.put(HPacketFormat.CSV, CsvHPacketSerializer.getInstance());
        serializerMap.put(HPacketFormat.JSON, JsonHPacketSerializer.getInstance());
        serializerMap.put(HPacketFormat.XML, XmlHPacketSerializer.getInstance());
        serializerMap.put(HPacketFormat.TEXT, PlainTextHPacketSerializer.getInstance());
    }

    public static HPacketSerializer getHPacketSerializer(HPacket packet) {
        return getHPacketSerializer(packet.getFormat());
    }

    public static HPacketSerializer getHPacketSerializer(HPacketFormat format) {
        if (!serializerMap.containsKey(format))
            throw new HyperIoTRuntimeException("HPacket Serializer not found");
        return serializerMap.get(format);
    }

}
