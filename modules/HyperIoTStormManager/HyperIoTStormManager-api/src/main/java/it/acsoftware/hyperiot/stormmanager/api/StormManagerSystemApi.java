/*
 * Copyright (C) AC Software, S.r.l. - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Gene <generoso.martello@acsoftware.it>, March 2019
 *
 */
package it.acsoftware.hyperiot.stormmanager.api;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseSystemApi;
import it.acsoftware.hyperiot.stormmanager.model.TopologyInfo;

import java.io.IOException;

/**
 * @author Aristide Cittadino Interface component for %- projectSuffixUC SystemApi. This
 * interface defines methods for additional operations.
 * @author Gene (generoso.martello@acsoftware.it)
 * @version 2019-03-19 Initial release
 */
public interface StormManagerSystemApi extends HyperIoTBaseSystemApi {

    /**
     * Get the topology name of a device.
     *
     * @param projectId The HProject id
     * @return
     */
    String getTopologyName(long projectId);


    /**
     * Generate topology files of a given project and submit it to the Storm cluster.
     *
     * @param projectId The project id
     * @throws IOException
     */
    void submitProjectTopology(long projectId) throws IOException;


    /**
     * Gets the list of topologies on Storm cluster.
     *
     * @return Topology list.
     */
    String getTopologyList() throws IOException;

    /**
     * Get status of a topology.
     *
     * @param projectId project ID
     * @return The TopologyStatus object.
     * @throws IOException
     */
    TopologyInfo getTopologyStatus(long projectId)
            throws IOException;

    /**
     * Activate a topology.
     *
     * @param topologyName Name of the topology to activate.
     * @throws IOException
     */
    void activateTopology(String topologyName)
            throws IOException;

    /**
     * Deactivate a topology.
     *
     * @param topologyName Name of the topology to deactivate.
     * @throws IOException
     */
    void deactivateTopology(String topologyName)
            throws IOException;

    /**
     * Kills a Storm topology.
     *
     * @param topologyName Name of the topology to kill.
     * @throws IOException
     */
    void killTopology(String topologyName)
            throws IOException;

}
