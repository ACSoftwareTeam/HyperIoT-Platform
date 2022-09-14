package it.acsoftware.hyperiot.camel.mqtt2kafka.component;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

import java.util.Map;

/**
 * @Author Aristide Cittadino
 * Camel2KafkaConnector
 */
public class HyperIoTMqtt2KafkaConnector extends DefaultComponent {
    public static final String HYPERIOT_CAMEL_MQTT_2_KAFKA_COMPONENT_NAME = "HyperIoTMqtt2Kafka";

    protected Endpoint createEndpoint(String uri, String remaining,
                                      Map<String, Object> parameters) throws Exception {
        HyperIoTMqtt2KafkaEndpoint endpoint = new HyperIoTMqtt2KafkaEndpoint(uri, remaining,
            this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
