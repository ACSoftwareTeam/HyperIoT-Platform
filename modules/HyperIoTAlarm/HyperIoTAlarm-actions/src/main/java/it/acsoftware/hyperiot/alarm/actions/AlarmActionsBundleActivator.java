package it.acsoftware.hyperiot.alarm.actions;

import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.action.HyperIoTActionList;
import it.acsoftware.hyperiot.base.action.HyperIoTPermissionActivator;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionFactory;

import it.acsoftware.hyperiot.alarm.model.Alarm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Aristide Cittadino Model class that define a bundle activator and
 * register actions for Alarm
 *
 */
public class AlarmActionsBundleActivator extends HyperIoTPermissionActivator {
	
	/**
	 * Return a list actions that have to be registerd as OSGi components
	 */
	@Override
	public List<HyperIoTActionList> getActions() {
		// creates base Actions save,update,remove,find,findAll for the specified entity
		getLog().info("Registering base CRUD actions...");
		List<HyperIoTActionList> actionList = new ArrayList<>();
		HyperIoTActionList alarmCrudActionList = HyperIoTActionFactory.createBaseCrudActionList(Alarm.class.getName(),
				Alarm.class.getName());
		HyperIoTActionList alarmEventCrudActionList =
				HyperIoTActionFactory.createBaseCrudActionList(AlarmEvent.class.getName(), AlarmEvent.class.getName());
		actionList.add(alarmCrudActionList);
		actionList.add(alarmEventCrudActionList);

		//TO DO: add more actions to actionList here...
		return actionList;
	}

}
