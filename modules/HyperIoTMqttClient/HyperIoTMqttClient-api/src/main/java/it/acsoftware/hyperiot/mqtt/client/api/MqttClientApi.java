package it.acsoftware.hyperiot.mqtt.client.api;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseApi;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * 
 * @author Aristide Cittadino Interface component for MqttClientApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface MqttClientApi extends HyperIoTBaseApi {
    public MqttClient createMqttClient(String mqttBrokerAddress, String username, String password, IMqttMessageListener listener) throws MqttException;
}