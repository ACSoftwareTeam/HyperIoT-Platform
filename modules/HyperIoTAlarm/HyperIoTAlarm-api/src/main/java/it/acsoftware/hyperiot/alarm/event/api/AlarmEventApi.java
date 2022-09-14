package it.acsoftware.hyperiot.alarm.event.api;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for AlarmEventApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface AlarmEventApi extends HyperIoTBaseEntityApi<AlarmEvent> {

    Collection<AlarmEvent> findAllEventByAlarmId(HyperIoTContext hyperIoTContext , long alarmId);

}