package it.acsoftware.hyperiot.dashboard.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;

import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for Dashboard
 *
 */
public class DashboardActionsBundleActivator extends HyperIoTPermissionActivator {

	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		getLog().info("Registering Dashboard actions...");
		List<HyperIoTActionList> actionList = new ArrayList<>();
		HyperIoTActionList dashboardActionList = HyperIoTActionFactory.createBaseCrudActionList(Dashboard.class.getName(),
				Dashboard.class.getName());
		dashboardActionList.addAction(HyperIoTActionFactory.createAction(Dashboard.class.getName(),
				Dashboard.class.getName(), HyperIoTDashboardAction.FIND_WIDGETS));
		HyperIoTActionList dashboardWidgetActionList = HyperIoTActionFactory.createBaseCrudActionList(DashboardWidget.class.getName(),
				DashboardWidget.class.getName());
		actionList.add(dashboardActionList);
		actionList.add(dashboardWidgetActionList);
		return actionList;
	}

}
