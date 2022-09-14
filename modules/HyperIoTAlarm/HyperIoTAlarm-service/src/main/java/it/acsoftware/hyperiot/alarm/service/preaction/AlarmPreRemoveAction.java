package it.acsoftware.hyperiot.alarm.service.preaction;

import it.acsoftware.hyperiot.alarm.event.api.AlarmEventSystemApi;
import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTQuery;
import it.acsoftware.hyperiot.query.util.filter.HyperIoTQueryBuilder;
import it.acsoftware.hyperiot.rule.api.RuleEngineSystemApi;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.alarm.model.Alarm"},immediate = true)
public class AlarmPreRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlarmPreRemoveAction.class.getName());

    private AlarmEventSystemApi alarmEventSystemApi;

    @Override
    public void execute(T entity) {
        long alarmId = entity.getId();
        LOGGER.debug("Delete events related to Alarm with id {}", alarmId);
        HyperIoTQuery byAlarmId = HyperIoTQueryBuilder.newQuery().equals("alarm.id", alarmId);
        Collection<AlarmEvent> alarmEvents =  alarmEventSystemApi.findAll(byAlarmId, null);
        alarmEvents.stream().sequential().forEach(alarmEvent -> {
            alarmEventSystemApi.remove(alarmEvent.getId(),null);
        });
    }

    @Reference
    public void setAlarmEventSystemApi(AlarmEventSystemApi alarmEventSystemApi) {
        this.alarmEventSystemApi = alarmEventSystemApi;
    }

}
