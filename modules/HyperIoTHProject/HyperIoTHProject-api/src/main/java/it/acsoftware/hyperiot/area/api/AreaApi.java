package it.acsoftware.hyperiot.area.api;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.area.model.AreaDevice;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for AreaApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface AreaApi extends HyperIoTBaseEntityApi<Area> {

    /**
     * Gets nested areas of the given area by id
     * @param context context
     * @param id The area id
     */
    Area getAll(HyperIoTContext context, long id);

    /**
     * Removes an area along with its nested areas
     *
     * @param context The HyperIoTContext instance
     * @param id The area id
     */
    void removeAll(HyperIoTContext context, long id);

    /**
     * Get area path from area tree root to the given area node.
     *
     * @param context The HyperIoTContext instance
     * @param areaId The area id
     * @return Areas in the path.
     */
    Collection<Area> getAreaPath(HyperIoTContext context, long areaId);

    /**
     * Adds or updates (if AreaDevice.id > 0) the area device
     *
     * @param context The HyperIoTContext instance
     * @param areaId The area id
     * @param areaDevice The area device
     */
    void saveAreaDevice(HyperIoTContext context, long areaId, AreaDevice areaDevice);

    /**
     * Gets an area device.
     *
     * @param context The HyperIoTContext instance
     * @param areaDeviceId The area device id
     * @return The area device
     */
    AreaDevice getAreaDevice(HyperIoTContext context, long areaDeviceId);

    /**
     * Removes the area device with id = `areaDeviceId`
     *
     * @param context The HyperIoTContext instance
     * @param areaId The area id
     * @param areaDeviceId The area device id
     */
    void removeAreaDevice(HyperIoTContext context, long areaId, long areaDeviceId);

    /**
     * Gets a list of devices belonging to the are with id `areaId`
     *
     * @param context The HyperIoTContext instance
     * @param areaId The area id.
     * @return List of devices
     */
    Collection<AreaDevice> getAreaDevicesList(HyperIoTContext context, long areaId);

    /**
     * Gets a list of devices belonging to the are with id `areaId` and its sub-areas
     *
     * @param context The HyperIoTContext instance
     * @param areaId The area id.
     * @param seekRoot Set to `true` to include all areas tree starting from root node, `false` otherwise.
     * @return List of devices
     */
    Collection<AreaDevice> getAreaDevicesDeepList(HyperIoTContext context, long areaId, boolean seekRoot);

}
