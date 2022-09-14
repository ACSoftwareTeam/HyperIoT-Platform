package it.acsoftware.hyperiot.hproject.deserialization.service;

import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.deserialization.api.HPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.model.HPacketInfo;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.JsonDecoder;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonAvroHPacketDeserializer implements HPacketDeserializer {

    private static JsonAvroHPacketDeserializer instance;

    private static final Logger log = LoggerFactory.getLogger(JsonAvroHPacketDeserializer.class);

    private JsonAvroHPacketDeserializer() { }

    public static synchronized JsonAvroHPacketDeserializer getInstance() {
        if (instance == null)
            instance = new JsonAvroHPacketDeserializer();
        return instance;
    }

    @Override
    public HPacket deserialize(byte[] rawHPacket, HPacketInfo hPacketInfo) throws IOException {
        HPacket hPacket = new HPacket();
        DatumReader<HPacket> reader = new SpecificDatumReader<>(hPacket.getSchema());
        JsonDecoder decoder =
                DecoderFactory.get().jsonDecoder(hPacket.getSchema(), new String(rawHPacket, StandardCharsets.UTF_8));
//        reader.setSchema(oldSchema);  read data with old schemas
        hPacket = reader.read(null, decoder);
        return hPacket;
    }

}
