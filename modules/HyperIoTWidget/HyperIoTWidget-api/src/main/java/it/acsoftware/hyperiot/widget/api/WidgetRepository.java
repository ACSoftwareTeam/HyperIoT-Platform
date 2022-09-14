package it.acsoftware.hyperiot.widget.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import it.acsoftware.hyperiot.widget.model.Widget;
import it.acsoftware.hyperiot.widget.model.WidgetCategory;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for Widget Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface WidgetRepository extends HyperIoTBaseRepository<Widget> {

    Collection<Widget> getWidgetsByCategory(WidgetCategory widgetCategory, String type);
	
}
