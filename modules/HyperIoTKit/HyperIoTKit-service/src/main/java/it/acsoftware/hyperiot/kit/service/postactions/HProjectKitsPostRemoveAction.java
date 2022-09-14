package it.acsoftware.hyperiot.kit.service.postactions;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPostRemoveAction;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTQuery;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.kit.api.KitSystemApi;
import it.acsoftware.hyperiot.kit.model.Kit;
import it.acsoftware.hyperiot.query.util.filter.HyperIoTQueryBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = HyperIoTPostRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hproject.model.HProject"},immediate = true)
public class HProjectKitsPostRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPostRemoveAction<T>  {

    private static final Logger LOGGER = LoggerFactory.getLogger(HProjectKitsPostRemoveAction.class.getName());

    private KitSystemApi kitSystemApi;

    @Override
    public void execute(T t) {
        HProject project = (HProject) t;
        long hProjectId = project.getId();
        HyperIoTQuery findByProjectId = HyperIoTQueryBuilder.newQuery().equals("projectId",hProjectId);
        Collection<Kit> projectKits = kitSystemApi.findAll(findByProjectId,null);
        projectKits.forEach((kit)->kitSystemApi.remove(kit.getId(),null));
    }

    @Reference
    public void setKitSystemApi(KitSystemApi kitSystemApi) {
        LOGGER.debug( "In HProjectKistPostRemoveAction invoking setKitSystemApi, setting: {}" , kitSystemApi);
        this.kitSystemApi = kitSystemApi;
    }

}
