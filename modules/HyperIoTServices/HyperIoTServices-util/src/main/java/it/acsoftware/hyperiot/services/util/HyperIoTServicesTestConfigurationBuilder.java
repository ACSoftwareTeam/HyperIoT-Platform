package it.acsoftware.hyperiot.services.util;

import it.acsoftware.hyperiot.base.test.HyperIoTTestConfiguration;
import it.acsoftware.hyperiot.base.test.HyperIoTTestConfigurationBuilder;

/**
 * @Author Aristide Cittadino
 * Class used for test configuration inside HyperIoTService modules.
 * This class use the default HyperIoTServices distribution instead of tbe default one.
 */
public class HyperIoTServicesTestConfigurationBuilder {
    public static HyperIoTTestConfiguration createStandardConfiguration() {
        return HyperIoTTestConfigurationBuilder.createStandardConfiguration()
                .withDistribution("it.acsoftware.hyperiot.container", "hyperiot-services-distribution-test", HyperIoTServicesUtil.getHyperIoTServicesVersion());
    }
}



