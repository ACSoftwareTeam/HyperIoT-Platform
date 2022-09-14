package it.acsoftware.hyperiot.area.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.acsoftware.hyperiot.hdevice.model.HDevice;

import java.io.IOException;


public class HProjectExportInnerDeviceInAreaDeviceSerializer extends JsonSerializer<HDevice> {

    @Override
    public void serialize(HDevice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("deviceName", value.getDeviceName());
        gen.writeEndObject();
    }
}
