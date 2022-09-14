package it.acsoftware.hyperiot.hproject.algorithm.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class HProjectAlgorithmActionsBundleActivator extends HyperIoTPermissionActivator {

    @Override
    public List<HyperIoTActionList> getActions() {
        // creates base Actions save,update,remove,find,findAll for the specified entity
        log.info("Registering actions...");
        List<HyperIoTActionList> actionList = new ArrayList<>();
        HyperIoTActionList hProjectAlgorithmActionList = HyperIoTActionFactory.createBaseCrudActionList(HProjectAlgorithm.class.getName(),
                HProjectAlgorithm.class.getName());
        hProjectAlgorithmActionList.addAction(HyperIoTActionFactory.createAction(HProjectAlgorithm.class.getName(),
                HProjectAlgorithm.class.getName(), HProjectAlgorithmAction.UPDATE_CONFIG));
        actionList.add(hProjectAlgorithmActionList);
        return actionList;
    }

}
