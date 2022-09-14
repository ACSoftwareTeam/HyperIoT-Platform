package it.acsoftware.hyperiot.hproject.algorithm.model.dto;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import it.acsoftware.hyperiot.algorithm.model.Algorithm;

import java.io.IOException;

public class HProjectExportInnerAlgorithmSerializer extends JsonSerializer<Algorithm> {

    @Override
    public void serialize(Algorithm value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("name", value.getName());
        gen.writeEndObject();
    }
}
