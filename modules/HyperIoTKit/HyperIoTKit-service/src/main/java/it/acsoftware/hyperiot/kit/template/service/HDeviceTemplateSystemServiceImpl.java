package it.acsoftware.hyperiot.kit.template.service;


import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.kit.template.api.HDeviceTemplateRepository;
import it.acsoftware.hyperiot.kit.template.api.HDeviceTemplateSystemApi;
import it.acsoftware.hyperiot.kit.template.model.HDeviceTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HDeviceTemplateSystemApi.class, immediate = true)
public class HDeviceTemplateSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<HDeviceTemplate> implements HDeviceTemplateSystemApi{

    private HDeviceTemplateRepository repository;

    public HDeviceTemplateSystemServiceImpl() {
        super(HDeviceTemplate.class);
    }

    @Override
    protected HDeviceTemplateRepository getRepository() {
        getLog().debug("invoking getRepository, returning: {}" , this.repository);
        return repository;
    }

    @Reference
    protected void setRepository(HDeviceTemplateRepository repository) {
        getLog().debug("invoking setRepository, setting: {}" , repository);
        this.repository = repository;
    }
}
