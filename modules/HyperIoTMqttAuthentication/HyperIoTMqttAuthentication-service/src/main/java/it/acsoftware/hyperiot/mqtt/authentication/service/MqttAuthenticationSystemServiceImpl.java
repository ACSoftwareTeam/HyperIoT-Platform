package it.acsoftware.hyperiot.mqtt.authentication.service;

import org.osgi.service.component.annotations.Component;

import it.acsoftware.hyperiot.mqtt.authentication.api.MqttAuthenticationSystemApi;


import  it.acsoftware.hyperiot.base.service.HyperIoTBaseSystemServiceImpl ;

/**
 * 
 * @author Aristide Cittadino Implementation class of the MqttAuthenticationSystemApi
 *         interface. This  class is used to implements all additional
 *         methods to interact with the persistence layer.
 */
@Component(service = MqttAuthenticationSystemApi.class, immediate = true)
public final class MqttAuthenticationSystemServiceImpl extends HyperIoTBaseSystemServiceImpl   implements MqttAuthenticationSystemApi {
	
	
}
