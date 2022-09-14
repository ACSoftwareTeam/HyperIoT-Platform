package it.acsoftware.hyperiot.hproject.api.hadoop;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseSystemApi;

import java.io.IOException;

public interface HProjectHadoopSystemApi extends HyperIoTBaseSystemApi {

    /**
     * It deletes Hadoop data of this project, i.e. data on HDFS and HBase
     *
     * @param projectId The project ID
     */
    void deleteHadoopData(long projectId) throws IOException;
}
