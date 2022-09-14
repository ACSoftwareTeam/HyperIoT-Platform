package it.acsoftware.hyperiot.widget.actions;

import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;

import it.acsoftware.hyperiot.widget.model.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for Widget
 *
 */
public class WidgetActionsBundleActivator extends HyperIoTPermissionActivator {

	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		// creates base Actions save,update,remove,find,findAll for the specified entity
		getLog().info("Registering base CRUD actions...");
		List<HyperIoTActionList> actionList = new ArrayList<>();
		HyperIoTActionList crudActionList =
				HyperIoTActionFactory.createBaseCrudActionList(Widget.class.getName(), Widget.class.getName());
		actionList.add(crudActionList);
		return actionList;
	}

}
