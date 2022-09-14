package it.acsoftware.hyperiot.services.test;

import it.acsoftware.hyperiot.base.test.HyperIoTTestRunner;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class HyperIoTServicesTestSuite {

    public static TestSuite suite() throws Throwable {
        return HyperIoTTestRunner.createHyperIoTTestSuite(
                "it.acsoftware.hyperiot.services.test",
                "it.acsoftware.hyperiot.dashboard.test",
                "it.acsoftware.hyperiot.dashboard.widget.test",
                "it.acsoftware.hyperiot.algorithm.test",
                "it.acsoftware.hyperiot.alarm.test",
                "it.acsoftware.hyperiot.alarm.event.test",
                "it.acsoftware.hyperiot.widget.test",
                "it.acsoftware.hyperiot.rule.test",
                "it.acsoftware.hyperiot.area.test",
                "it.acsoftware.hyperiot.hdevice.test",
                "it.acsoftware.hyperiot.hpacket.test",
                "it.acsoftware.hyperiot.hproject.test",
                //"it.acsoftware.hyperiot.stormmanager.test",
                "it.acsoftware.hyperiot.mqtt.client.test",
                "it.acsoftware.hyperiot.kit.test"
        );
    }
}
