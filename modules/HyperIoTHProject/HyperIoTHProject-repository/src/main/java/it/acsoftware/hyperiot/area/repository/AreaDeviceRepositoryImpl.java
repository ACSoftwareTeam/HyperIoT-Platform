package it.acsoftware.hyperiot.area.repository;

import it.acsoftware.hyperiot.area.api.AreaDeviceRepository;
import it.acsoftware.hyperiot.area.model.AreaDevice;
import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;
import org.apache.aries.jpa.template.JpaTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = AreaDeviceRepository.class, immediate = true)
public class AreaDeviceRepositoryImpl extends HyperIoTBaseRepositoryImpl<AreaDevice> implements AreaDeviceRepository {
    /**
     * Injecting the JpaTemplate to interact with database
     */
    private JpaTemplate jpa;

    /**
     * Constructor for a AreaRepositoryImpl
     */
    public AreaDeviceRepositoryImpl() {
        super(AreaDevice.class);
    }

    /**
     * @return The current jpaTemplate
     */
    @Override
    protected JpaTemplate getJpa() {
        getLog().debug( "invoking getJpa, returning: {}", jpa);
        return jpa;
    }

    /**
     * @param jpa Injection of JpaTemplate
     */
    @Override
    @Reference(target = "(osgi.unit.name=hyperiot-hProject-persistence-unit)")
    protected void setJpa(JpaTemplate jpa) {
        getLog().debug( "invoking setJpa, setting: {}", jpa);
        this.jpa = jpa;
    }

}
