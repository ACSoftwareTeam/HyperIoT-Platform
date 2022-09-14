package it.acsoftware.hyperiot.hproject.repository;

import it.acsoftware.hyperiot.huser.api.HUserRepository;
import it.acsoftware.hyperiot.huser.model.HUser;
import org.apache.aries.jpa.template.JpaTemplate;

import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;

import it.acsoftware.hyperiot.hproject.api.HProjectRepository ;
import it.acsoftware.hyperiot.hproject.model.HProject;

/**
 *
 * @author Aristide Cittadino Implementation class of the HProject. This
 *         class is used to interact with the persistence layer.
 *
 */
@Component(service=HProjectRepository.class,immediate=true)
public class HProjectRepositoryImpl extends HyperIoTBaseRepositoryImpl<HProject> implements HProjectRepository {
	/**
	 * Injecting the JpaTemplate to interact with database
	 */
	private JpaTemplate jpa;

	/**
	 * Injecting the HUserRepository to interact with database
	 */
	private HUserRepository hUserRepository;

	/**
	 * Constructor for a HProjectRepositoryImpl
	 */
	public HProjectRepositoryImpl() {
		super(HProject.class);
	}

	/**
	 *
	 * @return The current jpaTemplate
	 */
	@Override
	protected JpaTemplate getJpa() {
		getLog().debug( "invoking getJpa, returning: {}" , jpa);
		return jpa;
	}

	/**
	 * @param jpa Injection of JpaTemplate
	 */
	@Override
	@Reference(target = "(osgi.unit.name=hyperiot-hProject-persistence-unit)")
	protected void setJpa(JpaTemplate jpa) {
		getLog().debug( "invoking setJpa, setting: {}" , jpa);
		this.jpa = jpa;
	}

	/**
	 *
	 * @return The current hUserRepository
	 */
	protected HUserRepository gethUserRepository() {
		getLog().debug( "invoking gethUserRepository, returning: {}" , hUserRepository);
		return hUserRepository;
	}

	/**
	 * @param hUserRepository Injection of HUserRepository
	 */
	@Reference
	protected void sethUserRepository(HUserRepository hUserRepository) {
		getLog().debug( "invoking sethUserRepository, setting: {}" , hUserRepository);
		this.hUserRepository = hUserRepository;
	}

	@Override
	public HProject updateHProjectOwner(long projectId, long userId) {
		 HProject hProject =  this.jpa.txExpr(TransactionType.Required, entityManager -> {
			 HProject project = this.find(projectId, null);
			 HUser user = this.hUserRepository.find(userId, null);
			 project.setUser(user);
			 return entityManager.merge(project);
		});
		getLog().debug("In HProjectRepositoryImpl the user with id : {} is the new owner of the HProject with id : {}", userId, projectId);
		return hProject;
	}
}
