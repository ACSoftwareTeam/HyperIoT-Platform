package it.acsoftware.hyperiot.kit.actions;

import java.util.ArrayList;
import java.util.List;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;

import it.acsoftware.hyperiot.kit.category.actions.DiagnoseTypeAction;
import it.acsoftware.hyperiot.kit.category.model.DiagnoseType;
import it.acsoftware.hyperiot.kit.model.Kit;

/**
 * 
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for Kit
 *
 */
public class KitActionsBundleActivator extends HyperIoTPermissionActivator {
	
	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		// creates base Actions save,update,remove,find,findAll for the specified entity
		log.info("Registering base CRUD actions...");
		ArrayList<HyperIoTActionList> actionsLists = new ArrayList<>();
		
		HyperIoTActionList actionList = HyperIoTActionFactory.createBaseCrudActionList(Kit.class.getName(),
				Kit.class.getName());
		
		actionsLists.add(actionList);
		//TO DO: add more actions to actionList here...
		HyperIoTActionList diagnoseTypeActionList = HyperIoTActionFactory.createBaseCrudActionList(DiagnoseType.class.getName(),
				DiagnoseType.class.getName());
		actionsLists.add(diagnoseTypeActionList);
		return actionsLists;
	}

}
