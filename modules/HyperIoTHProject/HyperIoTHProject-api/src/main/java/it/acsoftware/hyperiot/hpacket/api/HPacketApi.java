package it.acsoftware.hyperiot.hpacket.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;
import it.acsoftware.hyperiot.hpacket.model.HPacket;
import it.acsoftware.hyperiot.hpacket.model.HPacketField;
import it.acsoftware.hyperiot.hpacket.model.HPacketType;

import java.util.Collection;
import java.util.List;

/**
 * @author Aristide Cittadino Interface component for HPacketApi. This interface
 * defines methods for additional operations.
 */
public interface HPacketApi extends HyperIoTBaseEntityApi<HPacket> {
    /**
     * Gets the list of packets defined for the device with id `deviceId`
     *
     * @param context  The HyperIoTContext instance
     * @param deviceId The device id
     * @return List of packets
     */
    Collection<HPacket> getPacketsList(HyperIoTContext context, long deviceId);

    /**
     * Gets the list of all packets defined for the project with id `projectId`
     *
     * @param context The HyperIoTContext instance
     * @param projectId The project id
     * @return List of packets
     */
    Collection<HPacket> getProjectPacketsList(HyperIoTContext context, long projectId);

    /**
     * Get the list of all project packets
     * @param context The HyperIoTContext instance
     * @param projectId
     * @return List of all packets
     */
    Collection<HPacket> getProjectPacketsTree(HyperIoTContext context, long projectId);

    /**
     * Return packets of a specific project filtered by type
     * @param projectId
     * @param types
     * @return
     */
    Collection<HPacket> getProjectPacketsListByType(HyperIoTContext context,long projectId, List<HPacketType> types);

    /**
     * @param contenxt
     * @param field
     */
    HPacketField updateHPacketField(HyperIoTContext contenxt, HPacketField field);

    /**
     * @param context
     * @param field
     */
    HPacketField addHPacketField(HyperIoTContext context, HPacketField field);

    /**
     * @param context
     * @param packetId
     * @return
     */
    Collection<HPacketField> getHPacketFieldsTree(HyperIoTContext context,long packetId);

    /**
     *
     * @param fieldId
     */
    void removeHPacketField(HyperIoTContext context, long fieldId, long packetId);

    HPacket findHPacketByHpacketFieldId(HyperIoTContext context, long hpacketFieldId);

}
