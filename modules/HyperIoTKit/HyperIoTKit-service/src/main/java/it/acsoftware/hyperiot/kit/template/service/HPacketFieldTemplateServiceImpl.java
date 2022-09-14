package it.acsoftware.hyperiot.kit.template.service;

import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntityServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketFieldTemplateApi;
import it.acsoftware.hyperiot.kit.template.api.HPacketFieldTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HPacketFieldTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketFieldTemplateApi.class, immediate = true)
public class HPacketFieldTemplateServiceImpl extends HyperIoTBaseEntityServiceImpl<HPacketFieldTemplate> implements HPacketFieldTemplateApi {

    private HPacketFieldTemplateSystemApi systemService;

    public HPacketFieldTemplateServiceImpl() {
        super(HPacketFieldTemplate.class);
    }

    @Override
    protected HPacketFieldTemplateSystemApi getSystemService() {
        getLog().debug("invoking getSystemService, returning: {}" , this.systemService);
        return systemService;
    }

    @Reference
    protected void setSystemService(HPacketFieldTemplateSystemApi systemService) {
        getLog().debug("invoking setSystemService, setting: {}" , systemService);
        this.systemService = systemService ;
    }
}
