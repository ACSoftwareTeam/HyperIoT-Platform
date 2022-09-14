package it.acsoftware.hyperiot.mqtt.client.api;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseApi;
import org.eclipse.paho.client.mqttv3.*;

/**
 * @author Aristide Cittadino Interface component for MqttClientApi. This interface
 * defines methods for additional operations.
 */
public interface MqttClient extends HyperIoTBaseApi {
    void connect(IMqttActionListener callback) throws MqttSecurityException, MqttException;

    boolean isConnected();

    void disconnect() throws MqttException;

    void publish(String topic, int qos, boolean retained, int id, byte[] payload) throws MqttException, MqttPersistenceException;

    void subscribe(String topic, int qos) throws MqttException;
}
