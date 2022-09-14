package it.acsoftware.hyperiot.services.test;

import it.acsoftware.hyperiot.services.util.HyperIoTServicesTestConfigurationBuilder;
import org.ops4j.pax.exam.ConfigurationFactory;
import org.ops4j.pax.exam.Option;


public class HyperIoTServicesTestConfiguration implements ConfigurationFactory {
    @Override
    public Option[] createConfiguration() {
        return HyperIoTServicesTestConfigurationBuilder.createStandardConfiguration()
                .withCodeCoverage("it.acsoftware.hyperiot.*")
                .build();
    }
}