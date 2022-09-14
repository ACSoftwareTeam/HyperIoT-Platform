package it.acsoftware.hyperiot.dashboard.widget.api;

import java.util.Collection;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;

import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;

/**
 * 
 * @author Aristide Cittadino Interface component for DashboardWidgetApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface DashboardWidgetApi extends HyperIoTBaseEntityApi<DashboardWidget> {
	
	/**
	 * Get dashboard widget configuration
	 * @param dashboardWidgetId Dashboard widget from which retrieve configuration
	 * @param ctx
	 * @return Dashboard widget configuration in JSON format
	 */
	String getDashboardWidgetConf(long dashboardWidgetId, HyperIoTContext ctx);
	
	/**
	 * Get dashboard widget configuration
	 * @param dashboardWidgetId Dashboard widget to update
	 * @param widgetConf New dashboard widget configuration, in JSON format
	 * @param ctx
	 * @return Updated dashboard widget
	 */
	DashboardWidget setDashboardWidgetConf(long dashboardWidgetId, String widgetConf, HyperIoTContext ctx);
	
	/**
	 * Get all dashboard widgets inside a particular dashboard
	 * @param dashboardId Dashboard containing the widgets to retrieve
	 * @param ctx
	 * @return All dashboard widgets inside the dashboard
	 */
	Collection<DashboardWidget> getAllDashboardWidget(long dashboardId, HyperIoTContext ctx);

	/**
	 * Updates all widgets configuration of the dashboard with the given id
	 *
	 * @param dashboardId The dashboard id
	 * @param widgets The widgets array
	 * @param ctx HyperIoTContext instance
	 * @return true if succeed, false otherwise
	 */
	void updateDashboardWidget(long dashboardId, DashboardWidget[] widgets, HyperIoTContext ctx);

}