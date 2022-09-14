package it.acsoftware.hyperiot.hpacket.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.hpacket.model.HPacketField;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Aristide Cittadino Interface component for HPacket Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface HPacketFieldRepository extends HyperIoTBaseRepository<HPacketField> {

    /**
     *
     * @param packetId the id of the packet associate to the field.
     * @return The root field of the packet. A Field is a root if he hasn's parentfield .
     */
    List<HPacketField> getHPacketRootField(long packetId);

    Collection<HPacketField> getHPacketFieldsTree(long packetId);
	
}
