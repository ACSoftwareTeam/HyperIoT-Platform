package it.acsoftware.hyperiot.stormmanager.service.preaction;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.stormmanager.api.StormManagerSystemApi;
import it.acsoftware.hyperiot.stormmanager.model.TopologyInfo;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author Aristide Cittadino
 * Pre-Remove Action which stops (if it is started) storm topology related to that project
 */
@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hproject.model.HProject"},immediate = true)
public class HProjectPreRemoveAction implements HyperIoTPreRemoveAction<HProject> {
    private static Logger log = LoggerFactory.getLogger(HProjectPreRemoveAction.class);

    private StormManagerSystemApi stormManagerSystemApi;

    @Reference
    public void setStormManagerSystemApi(StormManagerSystemApi stormManagerSystemApi) {
        this.stormManagerSystemApi = stormManagerSystemApi;
    }

    @Override
    public void execute(HProject project) {
        try {
            if(this.stormManagerSystemApi.getTopologyStatus(project.getId()).getStatus().equalsIgnoreCase(TopologyInfo.TOPOLOGY_STATUS_ACTIVE)) {
                this.stormManagerSystemApi.killTopology(this.stormManagerSystemApi.getTopologyName(project.getId()));
            }
        } catch (Throwable t) {
            log.error(t.getMessage(), t);
        }
    }
}
