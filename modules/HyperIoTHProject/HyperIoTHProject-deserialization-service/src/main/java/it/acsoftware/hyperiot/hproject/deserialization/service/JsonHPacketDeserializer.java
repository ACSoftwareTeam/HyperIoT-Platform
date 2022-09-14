package it.acsoftware.hyperiot.hproject.deserialization.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.*;
import it.acsoftware.hyperiot.hproject.deserialization.api.HPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.model.HPacketInfo;
import it.acsoftware.hyperiot.hproject.deserialization.service.util.HPacketDeserializerUtil;
import it.acsoftware.hyperiot.hproject.model.HProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class JsonHPacketDeserializer implements HPacketDeserializer {

    private static JsonHPacketDeserializer instance;

    private static final Logger log = LoggerFactory.getLogger(JsonHPacketDeserializer.class);

    private final ObjectMapper objectMapper;

    private JsonHPacketDeserializer() {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static synchronized JsonHPacketDeserializer getInstance() {
        if (instance == null)
            instance = new JsonHPacketDeserializer();
        return instance;
    }

    @Override
    public HPacket deserialize(byte[] rawHPacket, HPacketInfo hPacketInfo) throws IOException {
        HashMap<String, Object> message;
        TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {};
        // example input JSON packet
        /*
        {
          "id": "Multisensor 3", // this field is not used
          "humidity": 33.75,
          "gps.longitude": 122.04,
          "gps.latitude": 85.55,
          "temperature": 30.28
        }
        NOTE: also nested fields are allowed eg:
        {
          …
          "gps": {
            "longitude": 122.04,
            "latitude": 85.55
          }
          …
        }
        */
        message = objectMapper.readValue(rawHPacket, typeRef);
        log.debug("JSON Data : {}", message);
        // create and return the HPacket
        long projectId = hPacketInfo.getHProjectId();
        HProject project = HPacketDeserializerUtil.createHProject(projectId);
        long deviceId = hPacketInfo.getHDeviceId();
        HDevice device = HPacketDeserializerUtil.createHDevice(deviceId, project);
        long packetId = hPacketInfo.getHPacketId();
        return HPacketDeserializerUtil.createHPacket(packetId, device, hPacketInfo, message);
    }

}
