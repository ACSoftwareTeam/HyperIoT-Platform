package it.acsoftware.hyperiot.hproject.algorithm.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithmConfig;

public interface HProjectAlgorithmUtil {

    /**
     * This method serializes HProjectAlgorithmConfig through Jackson, providing default values if fields are not filled
     * @param config HProjectAlgorithmConfig
     * @return String
     */
    String getConfigString(HProjectAlgorithmConfig config) throws JsonProcessingException;

}
