package it.acsoftware.hyperiot.dashboard.service.preaction;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTQuery;
import it.acsoftware.hyperiot.dashboard.api.DashboardSystemApi;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.query.util.filter.HyperIoTQueryBuilder;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.area.model.Area"},immediate = true)
public class AreaPreRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AreaPreRemoveAction.class.getName());
    private DashboardSystemApi dashboardSystemApi;

    @Override
    public void execute(T entity) {
        long areaId = entity.getId();
        LOGGER.debug("Delete dashboards related to Area with id {}", areaId);
        HyperIoTQuery byAreaId = HyperIoTQueryBuilder.newQuery().equals("area.id",areaId);
        //finding manually in order to preserve hibernate cascading
        Collection<Dashboard> dashboards =  dashboardSystemApi.findAll(byAreaId,null);
        dashboards.stream().parallel().forEach(dashboard -> {
            dashboardSystemApi.remove(dashboard.getId(),null);
        });
    }

    @Reference
    private void setDashboardSystemApi(DashboardSystemApi dashboardSystemApi) {
        this.dashboardSystemApi = dashboardSystemApi;
    }

}
