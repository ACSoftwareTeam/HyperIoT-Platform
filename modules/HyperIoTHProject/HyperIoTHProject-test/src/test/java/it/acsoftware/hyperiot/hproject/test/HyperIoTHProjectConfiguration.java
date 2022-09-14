package it.acsoftware.hyperiot.hproject.test;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.services.util.HyperIoTServicesTestConfigurationBuilder;
import org.ops4j.pax.exam.ConfigurationFactory;
import org.ops4j.pax.exam.Option;

public class HyperIoTHProjectConfiguration implements ConfigurationFactory {

    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String hProjectResourceName = HProject.class.getName();
    static final String hDeviceResourceName = HDevice.class.getName();
    static final String hPacketResourceName = HPacket.class.getName();
    static final String areaResourceName = Area.class.getName();

    static final int defaultDelta = 10;
    static final int defaultPage = 1;

    static final String permissionHProject = "it.acsoftware.hyperiot.hproject.model.HProject";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";

    @Override
    public Option[] createConfiguration() {
        return HyperIoTServicesTestConfigurationBuilder.createStandardConfiguration()
                .withCodeCoverage("it.acsoftware.hyperiot.hproject.*",
                        "it.acsoftware.hyperiot.area.*",
                        "it.acsoftware.hyperiot.hdevice.*",
                        "it.acsoftware.hyperiot.hpacket.*")
                .build();
    }
}
