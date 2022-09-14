package it.acsoftware.hyperiot.hpacket.test;

import it.acsoftware.hyperiot.base.test.HyperIoTTestConfigurationBuilder;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.model.HProject;

public class HyperIoTHPacketConfiguration {

    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String hPacketResourceName = HPacket.class.getName();
    static final String hDeviceResourceName = HDevice.class.getName();
    static final String hProjectResourceName = HProject.class.getName();

    static final int defaultDelta = 10;
    static final int defaultPage = 1;

    static final String permissionHPacket = "it.acsoftware.hyperiot.hpacket.model.HPacket";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";

}
