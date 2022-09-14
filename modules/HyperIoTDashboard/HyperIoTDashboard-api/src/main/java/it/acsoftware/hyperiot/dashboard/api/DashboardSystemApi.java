package it.acsoftware.hyperiot.dashboard.api;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.hproject.model.HProject;

/**
 * @author Aristide Cittadino Interface component for Dashboard SystemApi. This
 * interface defines methods for additional operations.
 */
public interface DashboardSystemApi extends HyperIoTBaseEntitySystemApi<Dashboard> {
    void createHProjectDashboard(HProject project);
    void createAreaDashboard(Area area);
    void removeByAreaId(long areaId);
    void removeByHProjectId(long hProjectId);
}