package it.acsoftware.hyperiot.hproject.deserialization.service;

import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.deserialization.api.HPacketDeserializer;
import it.acsoftware.hyperiot.hproject.deserialization.model.HPacketInfo;
import it.acsoftware.hyperiot.hproject.deserialization.service.util.HPacketDeserializerUtil;
import it.acsoftware.hyperiot.hproject.model.HProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvHPacketDeserializer implements HPacketDeserializer {

    private static CsvHPacketDeserializer instance;

    private static final Logger log = LoggerFactory.getLogger(CsvHPacketDeserializer.class);

    private CsvHPacketDeserializer() { }

    public static synchronized CsvHPacketDeserializer getInstance() {
        if (instance == null)
            instance = new CsvHPacketDeserializer();
        return instance;
    }

    @Override
    public HPacket deserialize(byte[] rawHPacket, HPacketInfo hPacketInfo) throws IOException {
        HashMap<String, Object> message;
        // example CSV input packet
        /*
        "id","Multisensor 2","temperature",22.34,humidity,56.44,"gps.latitude",45.23,"gps.longitude",87.23
         */
        message = new HashMap<>();
        Pattern pattern = Pattern.compile("(\"(?:[^\"]|\"\")*\"|[^,\"\\n\\r]*)(,|\\r?\\n|\\r|$)");
        Matcher matcher = pattern.matcher(new String(rawHPacket));
        String match;
        String currentField = null;
        while (matcher.find()) {
            match = matcher.group(1);
            if (match != null) {
                match = match.trim().replaceAll("^\"|\"$", "").trim();
                if (currentField != null) {
                    message.put(currentField, match);
                    currentField = null;
                } else if (hPacketInfo.getSchema().getFields().containsKey(match)) {
                    currentField = match;
                }
            }
        }
        log.debug("CSV Data : {}", message);
        // create and return the HPacket
        long projectId = hPacketInfo.getHProjectId();
        HProject project = HPacketDeserializerUtil.createHProject(projectId);
        long deviceId = hPacketInfo.getHDeviceId();
        HDevice device = HPacketDeserializerUtil.createHDevice(deviceId, project);
        long packetId = hPacketInfo.getHPacketId();
        return HPacketDeserializerUtil.createHPacket(packetId, device, hPacketInfo, message);
    }

}
