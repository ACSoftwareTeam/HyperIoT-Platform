package it.acsoftware.hyperiot.dashboard.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.area.model.Area;

/**
 * @author Aristide Cittadino Interface component for Dashboard Repository.
 * It is used for CRUD operations,
 * and to interact with the persistence layer.
 */
public interface DashboardRepository extends HyperIoTBaseRepository<Dashboard> {
    void createHProjectDashboard(HProject project);
    void createAreaDashboard(Area area);
}
