package it.acsoftware.hyperiot.widget.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;

import it.acsoftware.hyperiot.widget.model.Widget;
import it.acsoftware.hyperiot.widget.model.WidgetCategory;

import java.util.Collection;

/**
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 * interface defines methods for additional operations.
 */
public interface WidgetSystemApi extends HyperIoTBaseEntitySystemApi<Widget> {
    /**
     * HUser logged rating a widget
     *
     * @param rating
     * @param w
     * @param ctx
     */
    void rateWidget(int rating, Widget w, HyperIoTContext ctx);

    /**
     * @param widgetCategory
     * @param type
     * @return
     */
    Collection<Widget> getWidgetsByCategory(WidgetCategory widgetCategory, String type);

}
