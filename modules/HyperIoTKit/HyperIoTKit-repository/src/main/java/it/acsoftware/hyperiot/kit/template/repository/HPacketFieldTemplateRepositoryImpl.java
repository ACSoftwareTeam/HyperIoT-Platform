package it.acsoftware.hyperiot.kit.template.repository;


import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;
import it.acsoftware.hyperiot.kit.template.api.HPacketFieldTemplateRepository;
import it.acsoftware.hyperiot.kit.template.model.HPacketFieldTemplate;
import org.apache.aries.jpa.template.JpaTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = HPacketFieldTemplateRepository.class, immediate = true)
public class HPacketFieldTemplateRepositoryImpl extends HyperIoTBaseRepositoryImpl<HPacketFieldTemplate> implements HPacketFieldTemplateRepository {

    private JpaTemplate jpa;

    public HPacketFieldTemplateRepositoryImpl() {
        super(HPacketFieldTemplate.class);
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
