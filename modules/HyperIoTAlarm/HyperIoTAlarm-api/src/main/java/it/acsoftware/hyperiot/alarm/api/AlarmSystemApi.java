package it.acsoftware.hyperiot.alarm.api;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;

import it.acsoftware.hyperiot.alarm.model.Alarm;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface AlarmSystemApi extends HyperIoTBaseEntitySystemApi<Alarm> {

    Alarm saveAlarmAndEvents (Alarm alarm, Collection<AlarmEvent> alarmEvents, HyperIoTContext ctx );

    Set<Alarm> findAlarmByProjectId(HyperIoTContext hyperIoTContext , long projectId);
}