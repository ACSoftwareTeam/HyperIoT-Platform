package it.acsoftware.hyperiot.hproject.serialization.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.serialization.api.HPacketSerializer;
import org.apache.avro.Schema;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Author Aristide Cittadino
 * Class implementing JSON HPacket serializer
 */
public class JsonHPacketSerializer implements HPacketSerializer {
    private static JsonHPacketSerializer instance;
    private ObjectMapper mapper;

    private JsonHPacketSerializer() {

        this.mapper = new ObjectMapper();
    }

    public static synchronized JsonHPacketSerializer getInstance() {
        if (instance == null)
            instance = new JsonHPacketSerializer();
        return instance;
    }

    @Override
    public byte[] serialize(HPacket hPacket) throws IOException {
        return mapper.writeValueAsString(hPacket).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] serializeRaw(HPacket hPacket) throws IOException {
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
            .writeValueAsString(hPacket.getFlatFieldsMapWithValues());
        return jsonResult.getBytes(StandardCharsets.UTF_8);
    }
}
