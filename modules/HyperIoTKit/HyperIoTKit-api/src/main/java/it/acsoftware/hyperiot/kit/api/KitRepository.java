package it.acsoftware.hyperiot.kit.api;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import it.acsoftware.hyperiot.kit.model.Kit;

/**
 * 
 * @author Aristide Cittadino Interface component for Kit Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface KitRepository extends HyperIoTBaseRepository<Kit> {

    long[] getKitCategories(long kitId);

}
