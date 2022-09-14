package it.acsoftware.hyperiot.mqtt.authentication;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.security.JaasAuthenticationPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HyperIoTMqttAuthenticationPlugin extends JaasAuthenticationPlugin {
    private static Logger log = LoggerFactory.getLogger(HyperIoTMqttAuthenticationPlugin.class.getName());

    @Override
    public Broker installPlugin(Broker broker) {
        log.info( "Installing and initializing HyperIoTMqttAuthenticationPlugin...");
        return new HyperIoTBrokerAuthFilter(broker);
    }
}
