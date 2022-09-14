package it.acsoftware.hyperiot.dashboard.widget.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for DashboardWidget Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface DashboardWidgetRepository extends HyperIoTBaseRepository<DashboardWidget> {
    void updateDashboardWidget(DashboardWidget[] widgetConfiguration);

    Collection<DashboardWidget> getAllDashboardWidget(long dashboardId);

    Collection<DashboardWidget> getAllDashboardWidgetByPacketId(long packetId);

    Collection<DashboardWidget> getAllDashboardWidgetByHProjectAlgorithmId(long hProjectAlgorithmId);


}
