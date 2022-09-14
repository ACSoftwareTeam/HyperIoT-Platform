package it.acsoftware.hyperiot.mqtt.client.service;

import it.acsoftware.hyperiot.mqtt.client.api.MqttClient;
import it.acsoftware.hyperiot.mqtt.client.util.MqttClientUtil;
import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class MqttClientImpl implements MqttClient {

    private MqttConnectOptions options;
    private IMqttAsyncClient client;
    private IMqttMessageListener listener;

    public MqttClientImpl(String mqttBrokerAddress, String username, String password, IMqttMessageListener listener) throws MqttException {
        this.listener = listener;
        this.options = new MqttConnectOptions();
        this.client = new MqttAsyncClient(mqttBrokerAddress, username+ UUID.randomUUID().toString());
        options.setAutomaticReconnect(MqttClientUtil.getAutomaticReconnect());
        options.setCleanSession(MqttClientUtil.getCleanSession());
        options.setConnectionTimeout(MqttClientUtil.getConnectionTimeout());
        options.setKeepAliveInterval(MqttClientUtil.getKeepAlive());
        options.setUserName(username);
        options.setPassword(password.toCharArray());
    }

    public MqttClientImpl(String mqttBrokerAddress, String username, String password, IMqttMessageListener listener,MqttCallback callback) throws MqttException {
        this(mqttBrokerAddress,username,password,listener);
        client.setCallback(callback);
    }

    public void connect(IMqttActionListener callback) throws MqttSecurityException, MqttException {
        client.connect(options,null,callback);
    }

    public boolean isConnected() {
        return client != null && client.isConnected();
    }

    public void disconnect() throws MqttException {
        this.client.disconnect();
    }

    public void publish(String topic, int qos, boolean retained, int id, byte[] payload) throws MqttException, MqttPersistenceException {
        MqttMessage m = new MqttMessage();
        m.setPayload(payload);
        m.setQos(qos);
        m.setId(id);
        m.setRetained(retained);
        this.client.publish(topic, m);
    }

    public void subscribe(String topic, int qos) throws MqttException {
        this.client.subscribe(topic, qos, listener);
    }

}