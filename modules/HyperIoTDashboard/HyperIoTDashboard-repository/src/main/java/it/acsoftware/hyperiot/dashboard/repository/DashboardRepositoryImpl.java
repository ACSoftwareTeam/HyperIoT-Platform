package it.acsoftware.hyperiot.dashboard.repository;

import it.acsoftware.hyperiot.dashboard.model.DashboardType;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.area.model.Area;
import org.apache.aries.jpa.template.JpaTemplate;

import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;

import it.acsoftware.hyperiot.dashboard.api.DashboardRepository ;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;

/**
 *
 * @author Aristide Cittadino Implementation class of the Dashboard. This
 *         class is used to interact with the persistence layer.
 *
 */
@Component(service=DashboardRepository.class,immediate=true)
public class DashboardRepositoryImpl extends HyperIoTBaseRepositoryImpl<Dashboard> implements DashboardRepository {
	/**
	 * Injecting the JpaTemplate to interact with database
	 */
	private JpaTemplate jpa;

	/**
	 * Constructor for a DashboardRepositoryImpl
	 */
	public DashboardRepositoryImpl() {
		super(Dashboard.class);
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
	@Reference(target = "(osgi.unit.name=hyperiot-dashboard-persistence-unit)")
	protected void setJpa(JpaTemplate jpa) {
		getLog().debug( "invoking setJpa, setting: {}" , jpa);
		this.jpa = jpa;
	}

	@Override
	public void createHProjectDashboard(HProject project) {
		this.jpa.tx(TransactionType.Required, entityManager -> {
			Dashboard offlineD = new Dashboard();
			offlineD.setDashboardType(DashboardType.OFFLINE);
			offlineD.setHProject(project);
			offlineD.setName(project.getName()+" Offline Dashboard");
			Dashboard onlineD = new Dashboard();
			onlineD.setDashboardType(DashboardType.REALTIME);
			onlineD.setHProject(project);
			onlineD.setName(project.getName()+" Online Dashboard");
			entityManager.persist(offlineD);
			entityManager.persist(onlineD);
		});
	}

	@Override
	public void createAreaDashboard(Area area) {
		this.jpa.tx(TransactionType.Required, entityManager -> {
			Dashboard offlineD = new Dashboard();
			offlineD.setDashboardType(DashboardType.OFFLINE);
			offlineD.setHProject(area.getProject());
			offlineD.setArea(area);
			offlineD.setName(area.getName()+" Offline Dashboard");
			Dashboard onlineD = new Dashboard();
			onlineD.setDashboardType(DashboardType.REALTIME);
			onlineD.setHProject(area.getProject());
			onlineD.setArea(area);
			onlineD.setName(area.getName()+" Online Dashboard");
			entityManager.persist(offlineD);
			entityManager.persist(onlineD);
		});
	}
}
