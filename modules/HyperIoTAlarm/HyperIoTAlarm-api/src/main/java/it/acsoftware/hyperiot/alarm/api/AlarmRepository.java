package it.acsoftware.hyperiot.alarm.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import it.acsoftware.hyperiot.alarm.model.Alarm;

/**
 * 
 * @author Aristide Cittadino Interface component for Alarm Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface AlarmRepository extends HyperIoTBaseRepository<Alarm> {
	
}
