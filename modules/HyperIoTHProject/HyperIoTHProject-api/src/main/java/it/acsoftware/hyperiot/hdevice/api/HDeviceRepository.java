package it.acsoftware.hyperiot.hdevice.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.hdevice.model.HDevice;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for HDevice Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface HDeviceRepository extends HyperIoTBaseRepository<HDevice> {
	public HDevice findHDeviceAdmin();

	HDevice findDeviceByScreenName(String deviceName);

	Collection<HDevice> getProjectDevicesList(long projectId);

	/**
	 * @param device HDevice instance on which perform action
	 * @param newPassword newPassword
	 * @param passwordConfirm passwordConfirm
	 * @return HDevice instance
	 */
	HDevice changePassword(HDevice device, String newPassword, String passwordConfirm);
}
