package it.acsoftware.hyperiot.dashboard.service.postaction;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPostSaveAction;
import it.acsoftware.hyperiot.dashboard.api.DashboardSystemApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = HyperIoTPostSaveAction.class, property = {"type=it.acsoftware.hyperiot.area.model.Area"},immediate = true)
public class AreaPostSaveAction<T extends HyperIoTBaseEntity> implements HyperIoTPostSaveAction<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaPostSaveAction.class.getName());
    private DashboardSystemApi dashboardSystemApi;

    @Override
    public void execute(T entity) {
        LOGGER.debug("Create default online dashboard and offline dashboard automatically");
        Area area = (Area) entity;
        try {
            this.dashboardSystemApi.createAreaDashboard(area);
        } catch (Exception e) {
            LOGGER.error( e.getMessage(), e);
        }
    }

    @Reference
    public void setDashboardSystemApi(DashboardSystemApi dashboardSystemApi) {
        this.dashboardSystemApi = dashboardSystemApi;
    }

}
