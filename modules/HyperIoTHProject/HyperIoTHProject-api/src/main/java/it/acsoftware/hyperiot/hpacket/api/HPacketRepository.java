package it.acsoftware.hyperiot.hpacket.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.hpacket.model.HPacket;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for HPacket Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface HPacketRepository extends HyperIoTBaseRepository<HPacket> {

    Collection<HPacket> getProjectPacketsTree(long projectId) ;

    Collection<HPacket> getProjectPacketsList(long projectId);

    Collection<HPacket> getPacketsList(long deviceId);

    Collection<HPacket> findByDeviceId(long deviceId);

	
}
