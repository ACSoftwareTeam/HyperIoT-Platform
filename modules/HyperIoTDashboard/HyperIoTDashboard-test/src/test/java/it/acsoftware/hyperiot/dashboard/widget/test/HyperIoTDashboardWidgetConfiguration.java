package it.acsoftware.hyperiot.dashboard.widget.test;

import it.acsoftware.hyperiot.base.test.HyperIoTTestConfigurationBuilder;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;
import it.acsoftware.hyperiot.hproject.model.HProject;

public class HyperIoTDashboardWidgetConfiguration {
    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String dashboardWidgetResourceName = DashboardWidget.class.getName();
    static final String dashboardResourceName = Dashboard.class.getName();
    static final String hProjectResourceName = HProject.class.getName();

    static final String permissionDashboardWidget = "it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";

    static final int defaultDelta = 10;
    static final int defaultPage = 1;
}
