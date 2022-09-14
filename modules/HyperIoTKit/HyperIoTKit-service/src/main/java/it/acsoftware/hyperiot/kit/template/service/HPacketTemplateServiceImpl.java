package it.acsoftware.hyperiot.kit.template.service;



import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntityServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateApi;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HPacketTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketTemplateApi.class, immediate = true)
public class HPacketTemplateServiceImpl extends HyperIoTBaseEntityServiceImpl<HPacketTemplate> implements HPacketTemplateApi {

    private HPacketTemplateSystemApi systemService;

    public HPacketTemplateServiceImpl() {
        super(HPacketTemplate.class);
    }

    @Override
    protected HPacketTemplateSystemApi getSystemService() {
        getLog().debug("invoking getSystemService, returning: {}" , this.systemService);
        return systemService;
    }

    @Reference
    protected void setSystemService(HPacketTemplateSystemApi systemService) {
        getLog().debug("invoking setSystemService, setting: {}" , systemService);
        this.systemService = systemService ;
    }
}
