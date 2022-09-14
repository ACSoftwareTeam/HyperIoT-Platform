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

import it.acsoftware.hyperiot.base.api.HyperIoTBaseApi;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.exception.HyperIoTUnauthorizedException;
import it.acsoftware.hyperiot.stormmanager.model.TopologyInfo;

import java.io.IOException;

/**
 * 
 * @author Aristide Cittadino Interface component for StormManagerApi. This interface
 *         defines methods for additional operations.
 *
 */
public interface StormManagerApi extends HyperIoTBaseApi {


    /**
     * Generates and submits a project topology

     * @param context
     * @param projectId
     * @throws IOException
     * @throws HyperIoTUnauthorizedException
     */
    void submitProjectTopology(HyperIoTContext context, long projectId) throws IOException, HyperIoTUnauthorizedException;


    /**
     * Gets status of a topology by project ID.
     *
     * @param context
     * @param projectId ID of the project.
     * @return The TopologyStatus object.
     * @throws IOException
     * @throws HyperIoTUnauthorizedException
     */
    TopologyInfo getTopologyStatus(HyperIoTContext context, long projectId)
            throws IOException, HyperIoTUnauthorizedException;

    /**
     * Activates a topology by project ID.
     *
     * @param context
     * @param projectId ID of the project.
     * @throws IOException
     * @throws HyperIoTUnauthorizedException
     */
    void activateTopology(HyperIoTContext context, long projectId)
            throws IOException, HyperIoTUnauthorizedException;

    /**
     * Deactivates a topology by project ID.
     *
     * @param context
     * @param projectId ID of the project.
     * @throws IOException
     * @throws HyperIoTUnauthorizedException
     */
    void deactivateTopology(HyperIoTContext context, long projectId)
            throws IOException, HyperIoTUnauthorizedException;

    /**
     * Kills a Storm topology by project ID.
     *
     * @param context
     * @param projectId ID of the project.
     * @throws IOException
     * @throws HyperIoTUnauthorizedException
     */
    void killTopology(HyperIoTContext context, long projectId)
            throws IOException, HyperIoTUnauthorizedException;


}