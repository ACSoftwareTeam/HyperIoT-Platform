package it.acsoftware.hyperiot.mqtt.client.service;

import it.acsoftware.hyperiot.base.service.HyperIoTBaseServiceImpl;
import it.acsoftware.hyperiot.mqtt.client.api.MqttClient;
import it.acsoftware.hyperiot.mqtt.client.api.MqttClientApi;
import it.acsoftware.hyperiot.mqtt.client.api.MqttClientSystemApi;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Aristide Cittadino Implementation class of MqttClientApi interface.
 * It is used to implement all additional methods in order to interact with the system layer.
 */
@Component(service = MqttClientApi.class, immediate = true)
public final class MqttClientServiceImpl extends HyperIoTBaseServiceImpl implements MqttClientApi {
    /**
     * Injecting the MqttClientSystemApi
     */
    private MqttClientSystemApi systemService;

    /**
     * @return The current MqttClientSystemApi
     */
    protected MqttClientSystemApi getSystemService() {
        getLog().debug( "invoking getSystemService, returning: {}" , this.systemService);
        return systemService;
    }

    /**
     * @param mqttClientSystemService Injecting via OSGi DS current systemService
     */
    @Reference
    protected void setSystemService(MqttClientSystemApi mqttClientSystemService) {
        getLog().debug( "invoking setSystemService, setting: {}" , systemService);
        this.systemService = mqttClientSystemService;
    }

    @Override
    public MqttClient createMqttClient(String mqttBrokerAddress, String username, String password, IMqttMessageListener listener) throws MqttException {
        return this.systemService.createMqttClient(mqttBrokerAddress, username, password, listener);
    }
}
