package it.acsoftware.hyperiot.widget.test;

import it.acsoftware.hyperiot.base.test.HyperIoTTestRunner;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class HyperIoTWidgetTestSuite {

    public static TestSuite suite() throws Throwable {
        return HyperIoTTestRunner.createHyperIoTTestSuite("it.acsoftware.hyperiot.widget.test");
    }

}
