package it.acsoftware.hyperiot.dashboard.widget.repository;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;
import it.acsoftware.hyperiot.dashboard.model.Dashboard;
import it.acsoftware.hyperiot.dashboard.widget.api.DashboardWidgetRepository;
import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;
import org.apache.aries.jpa.template.JpaTemplate;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Collection;


/**
 * @author Aristide Cittadino Implementation class of the DashboardWidget. This
 * class is used to interact with the persistence layer.
 */
@Component(service = DashboardWidgetRepository.class, immediate = true)
public class DashboardWidgetRepositoryImpl extends HyperIoTBaseRepositoryImpl<DashboardWidget> implements DashboardWidgetRepository {
    /**
     * Injecting the JpaTemplate to interact with database
     */
    private JpaTemplate jpa;

    /**
     * Constructor for a DashboardWidgetRepositoryImpl
     */
    public DashboardWidgetRepositoryImpl() {
        super(DashboardWidget.class);
    }

    /**
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
    public void updateDashboardWidget(DashboardWidget[] widgetConfiguration) {
        this.jpa.tx(TransactionType.Required, entityManager -> {
            Dashboard d = null;
            for (DashboardWidget w : widgetConfiguration) {
                if (d == null)
                    d = w.getDashboard();
                DashboardWidget storedWidget = this.find(w.getId(), null);
                storedWidget.setWidgetConf(w.getWidgetConf());
                entityManager.persist(storedWidget);
            }
            if (d != null) {
                entityManager.merge(d);
            }
            entityManager.flush();
        });
    }

    @Override
    public Collection<DashboardWidget> getAllDashboardWidget(long dashboardId) {
        return this.getJpa().txExpr(TransactionType.Required, (entityManager) -> {
            String query = "Select dw from DashboardWidget dw where dw.dashboard.id=:dashboardId";
            return  entityManager.createQuery(query).setParameter("dashboardId",dashboardId).getResultList();
        });
    }

    @Override
    public Collection<DashboardWidget> getAllDashboardWidgetByPacketId(long packetId) {
        return this.getJpa().txExpr(TransactionType.Required, (entityManager) -> {
            String query = String.format("select dw from DashboardWidget dw where dw.widgetConf like '%%\"packetId\":%s%%'", packetId);
            return  entityManager.createQuery(query).getResultList();
        });
    }

    @Override
    public Collection<DashboardWidget> getAllDashboardWidgetByHProjectAlgorithmId(long hProjectAlgorithmId) {
        return this.getJpa().txExpr(TransactionType.Required, (entityManager) -> {
            String query = String.format("select dw from DashboardWidget dw where dw.widgetConf like '%%\"hProjectAlgorithmId\":%s%%'",hProjectAlgorithmId);
            return  entityManager.createQuery(query).getResultList();
        });
    }


}
