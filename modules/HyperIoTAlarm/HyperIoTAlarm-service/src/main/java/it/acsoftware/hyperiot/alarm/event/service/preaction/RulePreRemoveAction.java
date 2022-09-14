package it.acsoftware.hyperiot.alarm.event.service.preaction;

import it.acsoftware.hyperiot.alarm.event.api.AlarmEventRepository;
import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.rule.model.Rule;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.rule.model.Rule"},immediate = true)
public class RulePreRemoveAction <T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T>{

    private static final Logger LOGGER = LoggerFactory.getLogger(RulePreRemoveAction.class.getName());

    private AlarmEventRepository alarmEventRepository;

    @Override
    public void execute(T t) {
        Rule rule = (Rule) t;
        long ruleId = rule.getId();
        LOGGER.debug("Delete AlarmEvent related to rule with id {}", ruleId);
        Collection<AlarmEvent> alarmEvents = alarmEventRepository.findByEventId(ruleId);
        if(alarmEvents != null && ! alarmEvents.isEmpty()){
            alarmEvents
                    .stream()
                    .sequential()
                    .forEach((alarmEvent -> this.alarmEventRepository.remove(alarmEvent.getId())));
        }
    }

    @Reference
    private void setAlarmEventRepository(AlarmEventRepository alarmEventRepository) {
        this.alarmEventRepository = alarmEventRepository;
    }
}
