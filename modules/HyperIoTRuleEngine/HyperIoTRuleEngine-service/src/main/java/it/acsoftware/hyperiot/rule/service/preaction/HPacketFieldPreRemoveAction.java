package it.acsoftware.hyperiot.rule.service.preaction;

import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTPreRemoveAction;
import it.acsoftware.hyperiot.rule.api.RuleEngineSystemApi;
import it.acsoftware.hyperiot.rule.model.Rule;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hpacket.model.HPacketField"})
public class HPacketFieldPreRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private static final Logger log = LoggerFactory.getLogger(HPacketFieldPreRemoveAction.class.getName());
    private RuleEngineSystemApi ruleEngineSystemApi;

    @Override
    public void execute(T entity) {
        long hPacketFieldId = entity.getId();
        log.debug("Delete rules related to HPacketField with id {}", hPacketFieldId);
        Collection<Rule> rules =  ruleEngineSystemApi.findAllRuleByHPacketFieldId(hPacketFieldId);
        for(Rule rule : rules){
            ruleEngineSystemApi.remove(rule.getId(),null);
        }
    }

    @Reference
    private void setRuleEngineSystemApi(RuleEngineSystemApi ruleEngineSystemApi) {
        this.ruleEngineSystemApi = ruleEngineSystemApi;
    }

}