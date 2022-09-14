package it.acsoftware.hyperiot.dashboard.test;

import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.services.util.HyperIoTServicesTestConfigurationBuilder;
import org.ops4j.pax.exam.ConfigurationFactory;
import org.ops4j.pax.exam.Option;


public class HyperIoTDashboardConfiguration implements ConfigurationFactory {
    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String hProjectResourceName = HProject.class.getName();
    static final String dashboardResourceName = Dashboard.class.getName();

    static final String permissionDashboard = "it.acsoftware.hyperiot.dashboard.model.Dashboard";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";

    static final int defaultDelta = 10;
    static final int defaultPage = 1;

    @Override
    public Option[] createConfiguration() {
        return HyperIoTServicesTestConfigurationBuilder.createStandardConfiguration()
                .withCodeCoverage("it.acsoftware.hyperiot.dashboard.*")
                .build();
    }
}
