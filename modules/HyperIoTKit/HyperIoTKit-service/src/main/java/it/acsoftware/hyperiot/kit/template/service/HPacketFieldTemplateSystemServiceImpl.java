package it.acsoftware.hyperiot.kit.template.service;

import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketFieldTemplateRepository;
import it.acsoftware.hyperiot.kit.template.api.HPacketFieldTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HPacketFieldTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketFieldTemplateSystemApi.class, immediate = true)
public class HPacketFieldTemplateSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<HPacketFieldTemplate> implements HPacketFieldTemplateSystemApi {


    private HPacketFieldTemplateRepository repository;


    public HPacketFieldTemplateSystemServiceImpl() {
        super(HPacketFieldTemplate.class);
    }

    @Override
    protected HPacketFieldTemplateRepository getRepository() {
        getLog().debug("invoking getRepository, returning: {}" , this.repository);
        return repository;
    }

    @Reference
    protected void setRepository(HPacketFieldTemplateRepository repository) {
        getLog().debug("invoking setRepository, setting: {}" , repository);
        this.repository = repository;
    }
}
