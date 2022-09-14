package it.acsoftware.hyperiot.hproject.serialization.service;

import it.acsoftware.hyperiot.hpacket.model.HPacket;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Author Giacomo Spanò
 * Class Wrapping Avro Serializer for Kafka messasging
 */
public class KafkaAvroHPacketSerializer implements Serializer<HPacket> {

    private static final Logger log = LoggerFactory.getLogger(KafkaAvroHPacketSerializer.class);
    private final AvroHPacketSerializer avroHPacketSerializer;

    public KafkaAvroHPacketSerializer() {
        this.avroHPacketSerializer = AvroHPacketSerializer.getInstance();
    }

    @Override
    public void close() {
        log.debug("closed");
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        log.debug("configure {} {}", configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, HPacket hPacket) {
        try {
            return avroHPacketSerializer.serialize(hPacket);
        } catch (IOException e) {
            throw new SerializationException(String.format("Cannot serialize data '%s' for topic '%s'", hPacket, topic), e);
        }
    }

}
