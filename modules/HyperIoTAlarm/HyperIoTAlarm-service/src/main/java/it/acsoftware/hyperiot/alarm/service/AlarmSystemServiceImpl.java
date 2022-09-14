package it.acsoftware.hyperiot.alarm.service;

import it.acsoftware.hyperiot.alarm.api.AlarmRepository;
import it.acsoftware.hyperiot.alarm.api.AlarmSystemApi;
import it.acsoftware.hyperiot.alarm.event.api.AlarmEventSystemApi;
import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.alarm.model.Alarm;
import it.acsoftware.hyperiot.base.action.util.HyperIoTActionsUtil;
import it.acsoftware.hyperiot.base.api.HyperIoTAction;
import it.acsoftware.hyperiot.base.api.HyperIoTContext;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTQuery;
import it.acsoftware.hyperiot.base.exception.HyperIoTEntityNotFound;
import it.acsoftware.hyperiot.base.service.entity.HyperIoTBaseEntitySystemServiceImpl;
import it.acsoftware.hyperiot.permission.api.PermissionSystemApi;
import it.acsoftware.hyperiot.query.util.filter.HyperIoTQueryBuilder;
import it.acsoftware.hyperiot.role.util.HyperIoTRoleConstants;
import it.acsoftware.hyperiot.rule.api.RuleEngineSystemApi;
import it.acsoftware.hyperiot.rule.model.Rule;
import org.apache.aries.jpa.template.TransactionType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Aristide Cittadino Implementation class of the AlarmSystemApi
 *         interface. This  class is used to implements all additional
 *         methods to interact with the persistence layer.
 */
@Component(service = AlarmSystemApi.class, immediate = true)
public final class AlarmSystemServiceImpl extends HyperIoTBaseEntitySystemServiceImpl<Alarm>   implements AlarmSystemApi {
	
	/**
	 * Injecting the AlarmRepository to interact with persistence layer
	 */
	private AlarmRepository repository;

	/**
	 * Injecting the PermissionSystemApi to interact with permission layer
	 */
	private PermissionSystemApi permissionSystemApi;

	private AlarmEventSystemApi alarmEventSystemApi;
	private RuleEngineSystemApi ruleEngineSystemApi;

	/**
	 * Constructor for a AlarmSystemServiceImpl
	 */
	public AlarmSystemServiceImpl() {
		super(Alarm.class);
	}

	/**
	 * Return the current repository
	 */
	protected AlarmRepository getRepository() {
		getLog().debug( "invoking getRepository, returning: {}" , this.repository);
		return repository;
	}
	
	/**
	 * @param alarmRepository The current value of AlarmRepository to interact with persistence layer
	 */
	@Reference
	public void setRepository(AlarmRepository alarmRepository) {
		getLog().debug( "invoking setRepository, setting: {}" , alarmRepository);
		this.repository = alarmRepository;
	}

	@Reference
	public void setAlarmEventSystemApi(AlarmEventSystemApi alarmEventSystemApi) {
		this.alarmEventSystemApi = alarmEventSystemApi;
	}

	@Reference
	public void setRuleEngineSystemApi(RuleEngineSystemApi ruleEngineSystemApi) {
		this.ruleEngineSystemApi = ruleEngineSystemApi;
	}


	public PermissionSystemApi getPermissionSystemApi() {
		getLog().debug("invoking getPermissionSystemApi, returning: {}", this.permissionSystemApi);
		return this.permissionSystemApi;
	}

	@Reference
	public void setPermissionSystemApi(PermissionSystemApi permissionSystemApi) {
		this.permissionSystemApi = permissionSystemApi;
	}

	@Override
	public Alarm update(Alarm entity, HyperIoTContext ctx) {
		Alarm dbEntity = null;
		try {
			dbEntity = this.find(entity.getId(), ctx);
		} catch (NoResultException e){
			throw new HyperIoTEntityNotFound();
		}
		boolean alarmNameChange = dbEntity.getName().equals(entity.getName());
		Alarm alarm =  super.update(entity, ctx);
		alarm = this.find(entity.getId(), ctx);
		if(alarmNameChange){
			for(AlarmEvent event : alarm.getAlarmEventList()){
				this.alarmEventSystemApi.update(event, ctx);
			}
		}
		return alarm;
	}

	@Override
	public Set<Alarm> findAlarmByProjectId(HyperIoTContext hyperIoTContext, long projectId) {
		Collection<Rule> projectRules = this.ruleEngineSystemApi.findAllRuleByProjectId(projectId);
		if (projectRules == null || projectRules.isEmpty())
			return new HashSet<>();
		HyperIoTQuery byRuleId = HyperIoTQueryBuilder.newQuery();
		boolean firstRule = true;
		for( Rule rule : projectRules){
			if(firstRule){
				byRuleId = byRuleId.equals("event",rule.getId());
				firstRule=false;
			} else{
				byRuleId = byRuleId.or(HyperIoTQueryBuilder.newQuery().equals("event" , rule.getId()));
			}
		}
		Collection<AlarmEvent> alarmEvents = this.alarmEventSystemApi.findAll(byRuleId, hyperIoTContext);
		Set<Alarm> alarm = new HashSet<>();
		alarmEvents.forEach((event) -> alarm.add(event.getAlarm()));
		return alarm;
	}


	@Override
	public Alarm saveAlarmAndEvents(Alarm alarm, Collection<AlarmEvent> alarmEvents, HyperIoTContext ctx) {
		return repository.executeTransactionWithReturn(TransactionType.Required, (em -> {
			Alarm savedAlarm = save(alarm, null);
			if (alarmEvents != null && ! alarmEvents.isEmpty()) {
				for (AlarmEvent alarmEvent : alarmEvents) {
					alarmEvent.setAlarm(alarm);
					AlarmEvent alarmEv = alarmEventSystemApi.save(alarmEvent, ctx);
					savedAlarm.getAlarmEventList().add(alarmEv);
				}
			}
			return savedAlarm;
		}));
	}


	@Activate
	public void onActivate(){
		this.checkRegisteredUserRoleExist();
	}

	private void checkRegisteredUserRoleExist(){
		String alarmResourceName = Alarm.class.getName();
		List<HyperIoTAction> alarmCrudAction = HyperIoTActionsUtil.getHyperIoTCrudActions(alarmResourceName);
		this.permissionSystemApi.checkOrCreateRoleWithPermissions(HyperIoTRoleConstants.ROLE_NAME_REGISTERED_USER, alarmCrudAction);
	}

}
