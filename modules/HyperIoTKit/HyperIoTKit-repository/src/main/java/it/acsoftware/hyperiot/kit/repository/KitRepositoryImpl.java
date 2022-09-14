package it.acsoftware.hyperiot.kit.repository;

import java.util.logging.Level;

import org.apache.aries.jpa.template.JpaTemplate;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;

import it.acsoftware.hyperiot.kit.api.KitRepository ;
import it.acsoftware.hyperiot.kit.model.Kit;

/**
 * 
 * @author Aristide Cittadino Implementation class of the Kit. This
 *         class is used to interact with the persistence layer.
 *
 */
@Component(service=KitRepository.class,immediate=true)
public class KitRepositoryImpl extends HyperIoTBaseRepositoryImpl<Kit> implements KitRepository {
	/**
	 * Injecting the JpaTemplate to interact with database
	 */
	private JpaTemplate jpa;

	/**
	 * Constructor for a KitRepositoryImpl
	 */
	public KitRepositoryImpl() {
		super(Kit.class);
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

	@Override
	public long[] getKitCategories(long kitId) {
		return this.getAssetCategoryManager().findAssetCategories(Kit.class.getName(),kitId);
	}
}
