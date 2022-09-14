package it.acsoftware.hyperiot.hproject.algorithm.service.preaction;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.hproject.algorithm.api.HProjectAlgorithmSystemApi;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hproject.model.HProject"},immediate = true)
public class HProjectPreRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private HProjectAlgorithmSystemApi hProjectAlgorithmSystemApi;

    private static final Logger LOGGER = LoggerFactory.getLogger(HProjectPreRemoveAction.class.getName());

    @Override
    public void execute(T entity) {
        long hProjectId = entity.getId();
        LOGGER.debug("Delete HProjectAlgorithm related to HProject with id {}", hProjectId);
        Collection<HProjectAlgorithm> hProjectAlgorithms = hProjectAlgorithmSystemApi.findByHProjectId(hProjectId);
        hProjectAlgorithms.forEach(
                hProjectAlgorithm -> hProjectAlgorithmSystemApi.remove(hProjectAlgorithm.getId(), null)
        );

    }

    @Reference
    public void setHProjectAlgorithmSystemApi(HProjectAlgorithmSystemApi hProjectAlgorithmSystemApi) {
        LOGGER.debug( "In HProjectPreRemoveAction invoking setHProjectAlgorithmSystemApi, setting: {}" , hProjectAlgorithmSystemApi);
        this.hProjectAlgorithmSystemApi = hProjectAlgorithmSystemApi;
    }
}
