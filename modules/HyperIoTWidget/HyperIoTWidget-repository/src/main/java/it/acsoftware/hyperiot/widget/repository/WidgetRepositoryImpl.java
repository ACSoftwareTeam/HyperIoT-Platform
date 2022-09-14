package it.acsoftware.hyperiot.widget.repository;

import it.acsoftware.hyperiot.widget.model.WidgetCategory;
import org.apache.aries.jpa.template.JpaTemplate;

import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import it.acsoftware.hyperiot.base.repository.HyperIoTBaseRepositoryImpl;

import it.acsoftware.hyperiot.widget.api.WidgetRepository ;
import it.acsoftware.hyperiot.widget.model.Widget;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Aristide Cittadino Implementation class of the Widget. This
 *         class is used to interact with the persistence layer.
 *
 */
@Component(service=WidgetRepository.class,immediate=true)
public class WidgetRepositoryImpl extends HyperIoTBaseRepositoryImpl<Widget> implements WidgetRepository {
	/**
	 * Injecting the JpaTemplate to interact with database
	 */
	private JpaTemplate jpa;

	/**
	 * Constructor for a WidgetRepositoryImpl
	 */
	public WidgetRepositoryImpl() {
		super(Widget.class);
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
	@Reference(target = "(osgi.unit.name=hyperiot-widget-persistence-unit)")
	protected void setJpa(JpaTemplate jpa) {
		getLog().debug( "invoking setJpa, setting: {}" , jpa);
		this.jpa = jpa;
	}

	@Override
	public Collection<Widget> getWidgetsByCategory(WidgetCategory widgetCategory, String type) {
		try {
			return this.getJpa().txExpr(TransactionType.Required, (entityManager) -> {
				String query = type.equals("realTime") ?
						"from Widget w where w.widgetCategory = :category AND w.realTime is true" :
						"from Widget w where w.widgetCategory = :category AND w.offline is true";
				return entityManager.createQuery(query).setParameter("category",widgetCategory).getResultList();
			});
		} catch (NoResultException e) {
			return null;
		}
	}
}
