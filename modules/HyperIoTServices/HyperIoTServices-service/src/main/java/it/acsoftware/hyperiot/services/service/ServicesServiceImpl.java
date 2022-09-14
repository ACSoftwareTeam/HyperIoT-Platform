package it.acsoftware.hyperiot.services.service;

import java.util.logging.Level;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.services.api.ServicesSystemApi;
import it.acsoftware.hyperiot.services.api.ServicesApi;

import  it.acsoftware.hyperiot.base.service.HyperIoTBaseServiceImpl;


/**
 * 
 * @author Aristide Cittadino Implementation class of ServicesApi interface.
 *         It is used to implement all additional methods in order to interact with the system layer.
 */
@Component(service = ServicesApi.class, immediate = true)
public final class ServicesServiceImpl extends  HyperIoTBaseServiceImpl  implements ServicesApi {
	/**
	 * Injecting the ServicesSystemApi
	 */
	private ServicesSystemApi systemService;
	
	/**
	 * 
	 * @return The current ServicesSystemApi
	 */
	protected ServicesSystemApi getSystemService() {
		getLog().debug("invoking getSystemService, returning: {}" , this.systemService);
		return systemService;
	}

	/**
	 * 
	 * @param servicesSystemService Injecting via OSGi DS current systemService 
	 */
	@Reference
	protected void setSystemService(ServicesSystemApi servicesSystemService) {
		getLog().debug("invoking setSystemService, setting: {}" , systemService);
		this.systemService = servicesSystemService ;
	}

}
