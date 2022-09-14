package it.acsoftware.hyperiot.dashboard.widget.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;

import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;

import java.util.Collection;

/**
 *
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface DashboardWidgetSystemApi extends HyperIoTBaseEntitySystemApi<DashboardWidget> {
    void updateDashboardWidget(DashboardWidget[] widgetConfiguration, HyperIoTContext ctx);
    void removeByProjectId(long hProjectId);

    Collection<DashboardWidget> getAllDashboardWidget(long dashboardId);

    Collection<DashboardWidget> getAllDashboardWidgetByPacketId(long packetId);

    Collection<DashboardWidget> getAllDashboardWidgetByHProjectAlgorithmId(long hProjectAlgorithmId);
}
