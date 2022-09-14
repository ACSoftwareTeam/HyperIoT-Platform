package it.acsoftware.hyperiot.kit.template.service;

import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntityServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HDeviceTemplateApi;
import it.acsoftware.hyperiot.kit.template.api.HDeviceTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HDeviceTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HDeviceTemplateApi.class, immediate = true)
public class HDeviceTemplateServiceImpl extends HyperIoTBaseEntityServiceImpl<HDeviceTemplate> implements HDeviceTemplateApi {


    private HDeviceTemplateSystemApi systemService;

    public HDeviceTemplateServiceImpl() {
        super(HDeviceTemplate.class);
    }

    @Override
    protected HDeviceTemplateSystemApi getSystemService() {
        getLog().debug("invoking getSystemService, returning: {}" , this.systemService);
        return systemService;
    }
    @Reference
    protected void setSystemService(HDeviceTemplateSystemApi systemService) {
        getLog().debug("invoking setSystemService, setting: {}" , systemService);
        this.systemService = systemService ;
    }
}
