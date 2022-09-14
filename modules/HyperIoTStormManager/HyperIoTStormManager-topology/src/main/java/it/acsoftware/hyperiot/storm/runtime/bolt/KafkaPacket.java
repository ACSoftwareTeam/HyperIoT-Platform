package it.acsoftware.hyperiot.storm.runtime.bolt;

import java.io.Serializable;

// RAW kafka packet
public class KafkaPacket implements Serializable {
    private static final long serialVersionUID = 1L;
    public String schema;
    public String payload;
}
