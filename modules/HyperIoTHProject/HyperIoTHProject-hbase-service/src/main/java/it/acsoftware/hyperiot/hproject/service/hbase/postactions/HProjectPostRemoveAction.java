package it.acsoftware.hyperiot.hproject.service.hbase.postactions;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPostRemoveAction;
import it.acsoftware.hyperiot.hproject.model.HProject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * This class deletes HBase table after removing HProject.
 * @param <T>
 */
@Component(service = HyperIoTPostRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hproject.model.HProject"})
public class HProjectPostRemoveAction <T extends HyperIoTBaseEntity> implements HyperIoTPostRemoveAction<T> {

    private static Logger log = LoggerFactory.getLogger(HProjectPostRemoveAction.class.getName());
    /**
     * Injecting the HProjectPostActionThreadPool
     */
    private HProjectPostActionThreadPool hProjectPostActionThreadPool;

    @Override
    public void execute(T entity) {
        HProject hProject = (HProject) entity;
        log.debug( "Drop HBase tables after deleting HProject with id {}", hProject.getId());
        hProjectPostActionThreadPool.runPostRemoveAction(hProject.getId());
    }

    /**
     *
     * @param hProjectPostActionThreadPool HProjectPostActionThreadPool service
     */
    @Reference
    public void sethProjectPostActionThreadPool(HProjectPostActionThreadPool hProjectPostActionThreadPool) {
        this.hProjectPostActionThreadPool = hProjectPostActionThreadPool;
    }

}
