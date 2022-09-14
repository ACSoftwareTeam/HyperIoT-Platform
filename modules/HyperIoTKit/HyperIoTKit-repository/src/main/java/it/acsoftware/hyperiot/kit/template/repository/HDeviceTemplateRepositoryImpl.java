package it.acsoftware.hyperiot.kit.template.repository;


import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;
import it.acsoftware.hyperiot.kit.template.api.HDeviceTemplateRepository;
import it.acsoftware.hyperiot.kit.template.model.HDeviceTemplate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HDeviceTemplateRepository.class, immediate = true)
public class HDeviceTemplateRepositoryImpl extends HyperIoTBaseRepositoryImpl<HDeviceTemplate> implements HDeviceTemplateRepository {
    private JpaTemplate jpa;

    public HDeviceTemplateRepositoryImpl() {
        super(HDeviceTemplate.class);
    }


    @Override
    protected JpaTemplate getJpa() {
        getLog().debug("invoking getJpa, returning: {}" , jpa);
        return jpa;
    }

    @Override
    @Reference(target = "(osgi.unit.name=hyperiot-kit-persistence-unit)")
    protected void setJpa(JpaTemplate jpa) {
        getLog().debug("invoking setJpa, setting: " + jpa);
        this.jpa = jpa;
    }
}
