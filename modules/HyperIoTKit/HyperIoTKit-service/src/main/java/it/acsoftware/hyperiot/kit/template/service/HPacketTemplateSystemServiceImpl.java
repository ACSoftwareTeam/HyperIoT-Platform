package it.acsoftware.hyperiot.kit.template.service;


import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateRepository;
import it.acsoftware.hyperiot.kit.template.api.HPacketTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HPacketTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketTemplateSystemApi.class, immediate = true)
public class HPacketTemplateSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<HPacketTemplate> implements HPacketTemplateSystemApi {

    private HPacketTemplateRepository repository;


    public HPacketTemplateSystemServiceImpl() {
        super(HPacketTemplate.class);
    }

    @Override
    protected HPacketTemplateRepository getRepository() {
        getLog().debug("invoking getRepository, returning: {}" , this.repository);
        return repository;
    }

    @Reference
    protected void setRepository(HPacketTemplateRepository repository) {
        getLog().debug("invoking setRepository, setting: {}" , repository);
        this.repository = repository;
    }
}
