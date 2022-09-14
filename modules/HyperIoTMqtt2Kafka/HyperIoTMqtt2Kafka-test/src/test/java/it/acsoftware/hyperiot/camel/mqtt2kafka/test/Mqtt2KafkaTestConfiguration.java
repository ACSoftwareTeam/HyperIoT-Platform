package it.acsoftware.hyperiot.camel.mqtt2kafka.test;

import it.acsoftware.hyperiot.services.util.HyperIoTServicesTestConfigurationBuilder;
import org.ops4j.pax.exam.ConfigurationFactory;
import org.ops4j.pax.exam.Option;

public class Mqtt2KafkaTestConfiguration implements ConfigurationFactory {

    @Override
    public Option[] createConfiguration() {
        return HyperIoTServicesTestConfigurationBuilder.createStandardConfiguration()
                .withCodeCoverage("it.acsoftware.hyperiot.camel.mqtt2kafka.*")
                .build();
    }
}