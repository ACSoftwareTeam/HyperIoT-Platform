package it.acsoftware.hyperiot.hpacket.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hpacket.model.HPacketType;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface HPacketSystemApi extends HyperIoTBaseEntitySystemApi<HPacket> {
	Collection<HPacket> findByDeviceId(long deviceId);
	Collection<HPacket> getPacketsList(long deviceId);
	Collection<HPacket> getProjectPacketsTree(long projectId);
}
