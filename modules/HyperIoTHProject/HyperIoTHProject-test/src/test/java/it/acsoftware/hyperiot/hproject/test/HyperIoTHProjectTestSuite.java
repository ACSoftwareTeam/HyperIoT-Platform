package it.acsoftware.hyperiot.hproject.test;

import it.acsoftware.hyperiot.base.test.HyperIoTTestRunner;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class HyperIoTHProjectTestSuite {

    public static TestSuite suite() throws Throwable {
        return HyperIoTTestRunner.createHyperIoTTestSuite("it.acsoftware.hyperiot.area.test",
                "it.acsoftware.hyperiot.hdevice.test",
                "it.acsoftware.hyperiot.hpacket.test",
                "it.acsoftware.hyperiot.hproject.test",
                "it.acsoftware.hyperiot.hproject.algorithm.test");
    }

}
