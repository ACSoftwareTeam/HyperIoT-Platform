package it.acsoftware.hyperiot.widget.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;
import it.acsoftware.hyperiot.widget.model.Widget;

import java.util.HashMap;

/**
 * @author Aristide Cittadino Interface component for WidgetApi. This interface
 * defines methods for additional operations.
 */
public interface WidgetApi extends HyperIoTBaseEntityApi<Widget> {
    /**
     * HUser logged rating a widget
     *
     * @param rating
     * @param w
     * @param ctx
     */
    void rateWidget(int rating, Widget w, HyperIoTContext ctx);

    /**
     * @return getWidgetsInCategories
     *
     * @param type realTime or offline
     */
    HashMap<String, Object> getWidgetsInCategories(String type);

}
