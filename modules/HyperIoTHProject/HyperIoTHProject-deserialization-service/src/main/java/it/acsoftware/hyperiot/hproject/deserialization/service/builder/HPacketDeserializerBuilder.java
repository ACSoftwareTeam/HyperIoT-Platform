package it.acsoftware.hyperiot.hproject.deserialization.service.builder;

import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;
import it.acsoftware.hyperiot.hpacket.model.HPacketFormat;
import it.acsoftware.hyperiot.hproject.deserialization.api.HPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.service.CsvHPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.service.JsonHPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.service.XmlHPacketDeserializer;

import java.util.EnumMap;
import java.util.Map;

public final class HPacketDeserializerBuilder {

    private static final Map<HPacketFormat, HPacketDeserializer> deserializerMap;

    static {
        deserializerMap = new EnumMap<>(HPacketFormat.class);
        deserializerMap.put(HPacketFormat.CSV, CsvHPacketDeserializer.getInstance());
        deserializerMap.put(HPacketFormat.JSON, JsonHPacketDeserializer.getInstance());
        deserializerMap.put(HPacketFormat.XML, XmlHPacketDeserializer.getInstance());
    }

    private HPacketDeserializerBuilder() {
        throw new IllegalStateException("Utility class");
    }

    public static HPacketDeserializer getDeserializer(HPacketFormat format) {
        if (!deserializerMap.containsKey(format))
            throw new HyperIoTRuntimeException("Deserializer not found");
        return deserializerMap.get(format);
    }

}
