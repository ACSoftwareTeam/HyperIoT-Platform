package it.acsoftware.hyperiot.area.api;

import it.acsoftware.hyperiot.area.model.Area;
import it.acsoftware.hyperiot.area.model.AreaDevice;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseRepository;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Aristide Cittadino Interface component for Area Repository.
 *         It is used for CRUD operations,
 *         and to interact with the persistence layer.
 *
 */
public interface AreaRepository extends HyperIoTBaseRepository<Area> {

    Collection<AreaDevice> getAreaDevicesDeepList(long areaId);

    /**
     *
     * @param projectId The id of the project
     * @return List of root area of the project. (An area is root if it hasn't parent)
     */
    List<Area> getRootProjectArea(long projectId);


    Collection<Area> getAreaListByProjectId(long projectId);

    Collection<Area> getInnerArea(long areaId);

}
