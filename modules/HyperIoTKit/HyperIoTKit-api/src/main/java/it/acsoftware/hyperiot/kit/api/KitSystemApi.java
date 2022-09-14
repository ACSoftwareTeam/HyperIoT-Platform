package it.acsoftware.hyperiot.kit.api;

import it.acsoftware.hyperiot.asset.tag.model.AssetTag;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntitySystemApi;

import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.kit.model.Kit;

import java.util.Collection;

/**
 * 
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 *         interface defines methods for additional operations.
 *
 */
public interface KitSystemApi extends HyperIoTBaseEntitySystemApi<Kit> {

    long[] getKitCategories(long kitId);

    Collection<AssetTag> getKitTags(long kitId, HyperIoTContext ctx);

    AssetTag addTagToKit(long kitId , AssetTag tag, HyperIoTContext ctx);

    void deleteTagFromKit(long kitId,long tagId, HyperIoTContext ctx);

    HDevice installHDeviceTemplateOnProject(HyperIoTContext ctx, long hProjectId, long kitId, String deviceName, long hdeviceTemplateId);

}