package it.acsoftware.hyperiot.widget.service;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntityServiceImpl;
import it.acsoftware.hyperiot.widget.api.WidgetApi;
import it.acsoftware.hyperiot.widget.api.WidgetSystemApi;
import it.acsoftware.hyperiot.widget.model.Widget;
import it.acsoftware.hyperiot.widget.model.WidgetCategory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author Aristide Cittadino Implementation class of WidgetApi interface.
 * It is used to implement all additional methods in order to interact with the system layer.
 */
@Component(service = WidgetApi.class, immediate = true)
public final class WidgetServiceImpl extends HyperIoTBaseEntityServiceImpl<Widget> implements WidgetApi {
    /**
     * Injecting the WidgetSystemApi
     */
    private WidgetSystemApi systemService;

    /**
     * Constructor for a WidgetServiceImpl
     */
    public WidgetServiceImpl() {
        super(Widget.class);
    }

    /**
     * @return The current WidgetSystemApi
     */
    protected WidgetSystemApi getSystemService() {
        getLog().debug( "invoking getSystemService, returning: {}" , this.systemService);
        return systemService;
    }

    @Override
    public HashMap<String, Object> getWidgetsInCategories(String type) {
        HashMap<String, Object> returnMap = new HashMap<>();
        List<WidgetCategory> categories = Arrays.asList(WidgetCategory.values());
        HashMap<WidgetCategory, Collection<Widget>> widgetMap = new HashMap<>();
        HashMap<String,WidgetCategory> catMap = new HashMap<>();
        for (int i = 0; i < categories.size(); i++) {
            widgetMap.put(categories.get(i), this.systemService.getWidgetsByCategory(categories.get(i), type));
            catMap.put(categories.get(i).name(), categories.get(i));
        }
        returnMap.put("catInfo", catMap);
        returnMap.put("widgetMap", widgetMap);
        return returnMap;
    }

    /**
     * @param widgetSystemService Injecting via OSGi DS current systemService
     */
    @Reference
    protected void setSystemService(WidgetSystemApi widgetSystemService) {
        getLog().debug( "invoking setSystemService, setting: {}" , systemService);
        this.systemService = widgetSystemService;
    }

    @Override
    public void rateWidget(int rating, Widget w, HyperIoTContext ctx) {
        this.systemService.rateWidget(rating, w, ctx);
    }
}
