package it.acsoftware.hyperiot.mqtt.authorization;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HyperIoTMqttAuthorizationPlugin implements BrokerPlugin {
	private static Logger log = LoggerFactory.getLogger(HyperIoTMqttAuthorizationPlugin.class.getName());

	@Override
	public Broker installPlugin(Broker broker) throws Exception {
		log.info( "Installing and initializing HyperIoTMqttAuthorizationPlugin...");
		return new HyperIoTBrokerFilter(broker);
	}

}
