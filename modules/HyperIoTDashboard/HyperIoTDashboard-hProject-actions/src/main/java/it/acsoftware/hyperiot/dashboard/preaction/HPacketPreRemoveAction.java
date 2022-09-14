package it.acsoftware.hyperiot.dashboard.preaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTQuery;
import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;
import it.acsoftware.hyperiot.dashboard.widget.api.DashboardWidgetSystemApi;
import it.acsoftware.hyperiot.dashboard.widget.model.DashboardWidget;
import it.acsoftware.hyperiot.query.util.filter.HyperIoTQueryBuilder;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hpacket.model.HPacket"})
public class HPacketPreRemoveAction <T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private static final Logger log = LoggerFactory.getLogger(HPacketPreRemoveAction.class.getName());
    private DashboardWidgetSystemApi dashboardWidgetSystemApi;
    private ObjectMapper objectMapper;

    @Activate
    public void onActivate() {
        objectMapper = new ObjectMapper();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(T entity) {
        long hPacketId = entity.getId();
        log.debug("Reset widget configuration related to HPacket with id {}", hPacketId);
        Collection<DashboardWidget> dashboardWidgets =  dashboardWidgetSystemApi.getAllDashboardWidgetByPacketId(hPacketId);
        dashboardWidgets.forEach(dashboardWidget -> {
            try {
                Map<String, Object> config = objectMapper.readValue(dashboardWidget.getWidgetConf(), Map.class);
                config.remove("config");
                dashboardWidget.setWidgetConf(objectMapper.writeValueAsString(config));
                dashboardWidgetSystemApi.update(dashboardWidget, null);
            } catch (IOException e) {
                log.error("Could not reset configuration of widget: ", e);
                throw new HyperIoTRuntimeException(e);
            }
        });
    }

    @Reference
    public void setDashboardWidgetSystemApi(DashboardWidgetSystemApi dashboardWidgetSystemApi) {
        this.dashboardWidgetSystemApi = dashboardWidgetSystemApi;
    }

}