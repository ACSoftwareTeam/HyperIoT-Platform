/*
 * Copyright (C) AC Software, S.r.l. - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Gene <generoso.martello@acsoftware.it>, March 2019
 *
 */
package it.acsoftware.hyperiot.stormmanager.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.stormmanager.model.StormManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for StormManager which is associated with HProject
 */
public class StormManagerActionsBundleActivator extends HyperIoTPermissionActivator {

    /**
     * Return a list actions that have to be registered as OSGi components
     */
    @Override
    public List<HyperIoTActionList> getActions() {
        // creates base Actions save,update,remove,find,findAll for the specified entity
        log.info("Registering base actions...");
        List<HyperIoTActionList> actionList = new ArrayList<>();
        HyperIoTActionList customActionList = HyperIoTActionFactory.createEmptyActionList(StormManager.class.getName());
        customActionList.addAction(HyperIoTActionFactory.createAction(StormManager.class.getName(),
                StormManager.class.getName(), HyperIoTStormManagerAction.UPLOAD_TOPOLOGY_JAR));
        actionList.add(customActionList);
        return actionList;
    }

}
