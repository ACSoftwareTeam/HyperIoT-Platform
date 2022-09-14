package it.acsoftware.hyperiot.hproject.api.hadoop;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseApi;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;

import java.io.IOException;

public interface HProjectHadoopApi extends HyperIoTBaseApi {

    void deleteHadoopData(HyperIoTContext context, long projectId) throws IOException;
}
