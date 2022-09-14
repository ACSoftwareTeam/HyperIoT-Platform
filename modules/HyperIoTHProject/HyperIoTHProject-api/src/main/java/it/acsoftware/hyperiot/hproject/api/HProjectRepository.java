package it.acsoftware.hyperiot.hproject.api;

import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;
import it.acsoftware.hyperiot.hproject.model.HProject;

/**
 * 
 * @author Aristide Cittadino Interface component for HProject Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface HProjectRepository extends HyperIoTBaseRepository<HProject> {

    HProject updateHProjectOwner(long projectId, long userId);
}
