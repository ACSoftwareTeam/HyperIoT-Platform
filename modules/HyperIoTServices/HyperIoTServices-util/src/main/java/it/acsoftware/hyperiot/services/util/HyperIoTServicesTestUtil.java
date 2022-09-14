package it.acsoftware.hyperiot.services.util;

import it.acsoftware.hyperiot.base.test.containers.HyperIoTDynamicContainersConfigurationBuilder;

public class HyperIoTServicesTestUtil {
    public static void initPlatformContainers() {
        HyperIoTDynamicContainersConfigurationBuilder.getInstance()
                .withAutoStart()
                .withZookeeperContainer()
                .withKafkaContainer()
                .withStormContainer()
                .withHadoopContainer()
                .withHBaseContainer()
                .withSparkContainer()
                .build();
    }
}
