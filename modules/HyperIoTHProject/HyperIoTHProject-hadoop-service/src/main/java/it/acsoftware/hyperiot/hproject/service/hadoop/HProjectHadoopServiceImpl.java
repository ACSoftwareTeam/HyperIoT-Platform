package it.acsoftware.hyperiot.hproject.service.hadoop;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseSystemApi;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.security.annotations.AllowPermissions;
import it.acsoftware.hyperiot.base.service.HyperIoTBaseServiceImpl;
import it.acsoftware.hyperiot.hproject.actions.HyperIoTHProjectAction;
import it.acsoftware.hyperiot.hproject.api.hadoop.HProjectHadoopApi;
import it.acsoftware.hyperiot.hproject.api.hadoop.HProjectHadoopSystemApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

@Component(service = HProjectHadoopApi.class,immediate = true)
public class HProjectHadoopServiceImpl extends HyperIoTBaseServiceImpl implements HProjectHadoopApi {

    private HProjectHadoopSystemApi systemService;

    @Override
    public HyperIoTBaseSystemApi getSystemService() {
        return systemService;
    }

    @Reference
    public void setSystemService(HProjectHadoopSystemApi systemService) {
        this.systemService = systemService;
    }

    @Override
    @AllowPermissions(actions = HyperIoTHProjectAction.Names.DELETE_HADOOP_DATA, checkById = true, idParamIndex = 1,systemApiRef = "it.acsoftware.hyperiot.hproject.api.HProjectSystemApi")
    public void deleteHadoopData(HyperIoTContext context, long projectId) throws IOException {
        systemService.deleteHadoopData(projectId);
    }
}
