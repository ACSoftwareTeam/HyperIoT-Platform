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

@Component(service = HyperIoTPreRemoveAction.class, property = {"type=it.acsoftware.hyperiot.hpacket.model.HPacket"})
public class HPacketPreRemoveAction<T extends HyperIoTBaseEntity> implements HyperIoTPreRemoveAction<T> {

    private static final Logger log = LoggerFactory.getLogger(HPacketPreRemoveAction.class.getName());
    private RuleEngineSystemApi ruleEngineSystemApi;

    @Override
    public void execute(T entity) {
        long hPacketId = entity.getId();
        log.debug("Delete rules related to HPacket with id {}", hPacketId);
        Collection<Rule> rules =  ruleEngineSystemApi.findAllRuleByPacketId(hPacketId);
        for(Rule rule : rules){
            ruleEngineSystemApi.remove(rule.getId(),null);
        }
    }

    @Reference
    private void setRuleEngineSystemApi(RuleEngineSystemApi ruleEngineSystemApi) {
        this.ruleEngineSystemApi = ruleEngineSystemApi;
    }

}
