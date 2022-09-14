package it.acsoftware.hyperiot.alarm.event.api;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for AlarmEvent Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface AlarmEventRepository extends HyperIoTBaseRepository<AlarmEvent> {

    AlarmEvent findByAlarmIdAndEventid(long alarmId, long eventId);

    Collection<AlarmEvent> findByEventId(long eventId);
}
