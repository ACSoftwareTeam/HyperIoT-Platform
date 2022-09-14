package it.acsoftware.hyperiot.services.service;

import java.util.logging.Level;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.services.api.ServicesSystemApi;


import  it.acsoftware.hyperiot.base.service.HyperIoTBaseSystemServiceImpl ;

/**
 * 
 * @author Aristide Cittadino Implementation class of the ServicesSystemApi
 *         interface. This  class is used to implements all additional
 *         methods to interact with the persistence layer.
 */
@Component(service = ServicesSystemApi.class, immediate = true)
public final class ServicesSystemServiceImpl extends HyperIoTBaseSystemServiceImpl   implements ServicesSystemApi {
	
	
}
