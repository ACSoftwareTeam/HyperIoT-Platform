package it.acsoftware.hyperiot.kit.api;

import it.acsoftware.hyperiot.asset.tag.model.AssetTag;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntityApi;

import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.kit.model.Kit;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for KitApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface KitApi extends HyperIoTBaseEntityApi<Kit> {

    Collection<AssetTag> getKitTags(long kitId, HyperIoTContext ctx);

    AssetTag addTagToKit(long kitId , AssetTag tag, HyperIoTContext ctx);

    void deleteTagFromKit(long kitId,long tagId, HyperIoTContext ctx);

    HDevice installHDeviceTemplateOnProject(HyperIoTContext ctx, long hProjectId, long kitId, String deviceName, long hdeviceTemplateId);

}