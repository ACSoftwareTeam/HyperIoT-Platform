package it.acsoftware.hyperiot.widget.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.widget.model.Widget;
import it.acsoftware.hyperiot.widget.model.WidgetRating;

/**
 * @author Aristide Cittadino Interface component for Widget Repository.
 * It is used for CRUD operations,
 * and to interact with the persistence layer.
 */
public interface WidgetRatingRepository extends HyperIoTBaseRepository<WidgetRating> {
    void rateWidget(int rating, Widget w, String loggedUsername);
}
