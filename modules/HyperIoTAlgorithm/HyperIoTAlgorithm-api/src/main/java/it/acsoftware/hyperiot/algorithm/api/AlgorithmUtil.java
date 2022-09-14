package it.acsoftware.hyperiot.algorithm.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.acsoftware.hyperiot.algorithm.model.Algorithm;
import it.acsoftware.hyperiot.algorithm.model.AlgorithmConfig;

public interface AlgorithmUtil {

    /**
     * This method serializes AlgorithmConfig through Jackson, providing default values if fields are not filled
     * @param baseConfig AlgorithmConfig
     * @return String
     */
    String getBaseConfigString(AlgorithmConfig baseConfig) throws JsonProcessingException;

    /**
     * HDFS directory containing jars of Spark jobs
     * @return String
     */
    String getJarBasePath();

    /**
     * HDFS full path directory containing jars of Spark jobs
     * @param a Algorithm from which path has to be calculated
     * @return String
     */
    String getJarFullPath(Algorithm a);

}
