package it.acsoftware.hyperiot.kit.category.repository;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;
import it.acsoftware.hyperiot.kit.category.api.DiagnoseTypeRepository;
import it.acsoftware.hyperiot.kit.category.model.DiagnoseType;
import org.apache.aries.jpa.template.JpaTemplate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service= DiagnoseTypeRepository.class,immediate=true)
public class DiagnoseTypeRepositoryImpl extends HyperIoTBaseRepositoryImpl<DiagnoseType> implements DiagnoseTypeRepository {


    private JpaTemplate jpa;

    public DiagnoseTypeRepositoryImpl() {
        super(DiagnoseType.class);
    }

    /**
     *
     * @return The current jpaTemplate
     */
    @Override
    protected JpaTemplate getJpa() {
        getLog().debug("invoking getJpa, returning: {}" , jpa);
        return jpa;
    }

    /**
     * @param jpa Injection of JpaTemplate
     */
    @Override
    @Reference(target = "(osgi.unit.name=hyperiot-kit-persistence-unit)")
    protected void setJpa(JpaTemplate jpa) {
        getLog().debug("invoking setJpa, setting: " + jpa);
        this.jpa = jpa;
    }


}
