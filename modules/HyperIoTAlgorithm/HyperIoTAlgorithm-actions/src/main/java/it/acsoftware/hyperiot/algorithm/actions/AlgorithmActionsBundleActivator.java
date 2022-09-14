package it.acsoftware.hyperiot.algorithm.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;

import it.acsoftware.hyperiot.algorithm.model.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for Algorithm
 *
 */
public class AlgorithmActionsBundleActivator extends HyperIoTPermissionActivator {

	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		// creates base Actions save,update,remove,find,findAll for the specified entity
		getLog().info("Registering Algorithm actions...");
		List<HyperIoTActionList> actionList = new ArrayList<>();
		HyperIoTActionList algorithmActionList = HyperIoTActionFactory.createBaseCrudActionList(Algorithm.class.getName(),
				Algorithm.class.getName());
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.ADD_IO_FIELD));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.DELETE_IO_FIELD));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.READ_BASE_CONFIG));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.UPDATE_BASE_CONFIG));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.UPDATE_JAR));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.UPDATE_IO_FIELD));
		algorithmActionList.addAction(HyperIoTActionFactory.createAction(Algorithm.class.getName(),
				Algorithm.class.getName(), AlgorithmAction.CONTROL_PANEL));
		actionList.add(algorithmActionList);
		return actionList;
	}

}
