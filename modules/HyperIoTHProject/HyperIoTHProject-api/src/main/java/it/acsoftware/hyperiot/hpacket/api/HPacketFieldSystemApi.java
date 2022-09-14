package it.acsoftware.hyperiot.hpacket.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;
import it.acsoftware.hyperiot.hpacket.model.HPacketField;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface HPacketFieldSystemApi extends HyperIoTBaseEntitySystemApi<HPacketField> {
    Collection<HPacketField> getHPacketFieldsTree(long packetId);
    void removeHPacketField(long fieldId);

    /**
     *
     * @param packetId the id of the packet associate to the field.
     * @return The root field of the packet. A Field is a root if he hasn's parentfield .
     */
    List<HPacketField> getHPacketRootField(long packetId);



}