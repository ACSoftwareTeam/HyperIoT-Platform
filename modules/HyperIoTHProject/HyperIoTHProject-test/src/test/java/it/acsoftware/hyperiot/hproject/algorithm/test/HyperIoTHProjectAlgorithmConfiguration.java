package it.acsoftware.hyperiot.hproject.algorithm.test;

import it.acsoftware.hyperiot.algorithm.model.Algorithm;
import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;
import it.acsoftware.hyperiot.hproject.model.HProject;


public class HyperIoTHProjectAlgorithmConfiguration  {

    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String hProjectResourceName = HProject.class.getName();
    static final String hDeviceResourceName = HDevice.class.getName();
    static final String hPacketResourceName = HPacket.class.getName();
    static final String areaResourceName = Area.class.getName();
    static final String algorithmResourceName = Algorithm.class.getName();
    static final String hprojectAlgorithmResourceName= HProjectAlgorithm.class.getName();

    static final int defaultDelta = 10;
    static final int defaultPage = 1;

    static final String defaultPasswordForUser="passwordPass&01";

    static final String defaultMaliciousValue = "<script>console.log()</script>";

    static final String permissionHProject ="it.acsoftware.hyperiot.hproject.model.HProject";
    static final String permissionHProjectAlgorithm = "it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";

}
