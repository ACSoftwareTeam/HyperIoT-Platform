package it.acsoftware.hyperiot.alarm.event.api;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface AlarmEventSystemApi extends HyperIoTBaseEntitySystemApi<AlarmEvent> {

    AlarmEvent findByAlarmIdAndEventId(long alarmId, long eventId);

    Collection<AlarmEvent> findByEventId(long eventId);

}