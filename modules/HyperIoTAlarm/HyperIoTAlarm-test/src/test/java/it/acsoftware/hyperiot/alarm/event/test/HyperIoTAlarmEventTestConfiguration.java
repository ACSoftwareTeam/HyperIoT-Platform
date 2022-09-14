package it.acsoftware.hyperiot.alarm.event.test;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.alarm.model.Alarm;
import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.rule.model.Rule;

public class HyperIoTAlarmEventTestConfiguration  {

    static final String hyperIoTException = "it.acsoftware.hyperiot.base.exception.";
    static final String hProjectResourceName = HProject.class.getName();
    static final String hDeviceResourceName = HDevice.class.getName();
    static final String hPacketResourceName = HPacket.class.getName();
    static final String areaResourceName = Area.class.getName();
    static final String ruleResourceName = Rule.class.getName();
    static final String alarmResourceName = Alarm.class.getName();
    static final String alarmEventResourceName = AlarmEvent.class.getName();
    static final String maliciousCodeString = "<script>console.log('hello')</script>";

    static final int defaultDelta = 10;
    static final int defaultPage = 1;

    static final String permissionHProject = "it.acsoftware.hyperiot.hproject.model.HProject";
    static final String nameRegisteredPermission = " RegisteredUser Permissions";


}
