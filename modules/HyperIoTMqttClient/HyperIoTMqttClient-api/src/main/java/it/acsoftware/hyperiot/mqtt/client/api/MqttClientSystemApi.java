package it.acsoftware.hyperiot.mqtt.client.api;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseSystemApi;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 * interface defines methods for additional operations.
 */
public interface MqttClientSystemApi extends HyperIoTBaseSystemApi {
    MqttClient createMqttClient(String mqttBrokerAddress, String username, String password, IMqttMessageListener listener) throws MqttException;

    void publishAsAdmin(MqttMessage message, String topic);
}
