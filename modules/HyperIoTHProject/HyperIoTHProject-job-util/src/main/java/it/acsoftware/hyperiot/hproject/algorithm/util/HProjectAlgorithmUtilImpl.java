package it.acsoftware.hyperiot.hproject.algorithm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.hproject.algorithm.api.HProjectAlgorithmUtil;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithmConfig;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;

@Component(service = HProjectAlgorithmUtil.class, immediate = true)
public class HProjectAlgorithmUtilImpl implements HProjectAlgorithmUtil {

    public String getConfigString(HProjectAlgorithmConfig config) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (config.getInput() == null) {
            config.setInput(new ArrayList<>());
        }
        if (config.getOutput() == null)
            config.setOutput(new ArrayList<>());
        return objectMapper.writeValueAsString(config);
    }

}
