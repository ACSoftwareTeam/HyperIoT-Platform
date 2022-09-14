package it.acsoftware.hyperiot.rule.service.actions.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.acsoftware.hyperiot.base.util.HyperIoTUtil;
import it.acsoftware.hyperiot.mail.api.MailSystemApi;
import it.acsoftware.hyperiot.mail.util.MailConstants;
import it.acsoftware.hyperiot.rule.api.RuleEngineSystemApi;
import it.acsoftware.hyperiot.rule.model.Rule;
import it.acsoftware.hyperiot.rule.model.RuleType;
import it.acsoftware.hyperiot.rule.model.actions.EventRuleAction;
import it.acsoftware.hyperiot.rule.model.actions.RuleAction;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;

import javax.persistence.DiscriminatorValue;
import java.util.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Component(service = RuleAction.class, immediate = true, property = {"it.acsoftware.hyperiot.rule.action.type=EVENT"})
@DiscriminatorValue("rule.action.name.sendMail")
public class SendMailAction extends EventRuleAction implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SendMailAction.class.getName());
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final RuleType ruleType = RuleType.EVENT;

    private String mailSender;
    private String recipients;
    private String ccRecipients;
    private String subject;
    private String body;

    /**
     * MailSystemApi and RuleEngineSystemApi reference must be explicitly set by
     * calling setBundleContext
     */
    private MailSystemApi mailService;
    private RuleEngineSystemApi ruleEngineService;

    public SendMailAction() {
        super();
    }

    @Override
    public void setBundleContext(BundleContext context) {
        if (context != null) {
            logger.debug("In SendMailAction.setBundleContext ");
            super.setBundleContext(context);
            ServiceReference<MailSystemApi> mailReference = bundleContext
                .getServiceReference(MailSystemApi.class);
            mailService = (MailSystemApi) bundleContext.getService(mailReference);
            ServiceReference<RuleEngineSystemApi> ruleEngineReference = bundleContext
                .getServiceReference(RuleEngineSystemApi.class);
            ruleEngineService = (RuleEngineSystemApi) bundleContext.getService(ruleEngineReference);
            // Set sender of events e-mail
            mailSender = "no-reply@hyperiot.cloud";
            Object sender = HyperIoTUtil.getHyperIoTProperty(MailConstants.MAIL_EVENT_SENDER);
            if (sender != null && !sender.toString().isEmpty()) {
                mailSender = sender.toString();
            }
        }
    }

    @Override
    public String droolsDefinition(String packetVariable) {
        return this.droolsAsJson();
    }

    @Override
    public void run() {
        logger.debug("Starting SendMail Action ....");
        /*
         * Define placeholders which will be in mail body.
         * Pay attention: their name must match the ones given on frontend
         */
        final String RULE_NAME_PLACEHOLDER = "RULE_NAME";
        final String RULE_DESCRIPTION_PLACEHOLDER = "RULE_DESCRIPTION";

        Rule rule = ruleEngineService.find(this.getRuleId(), null);
        if (rule != null) {
            logger.debug("Rule Found: " + rule.getDescription());
            List<String> recipientList = Arrays.asList(recipients.split(";"));
            List<String> ccRecipientList = ccRecipients.isEmpty() ?
                null : Arrays.asList(ccRecipients.split(";"));
            // add template variables
            HashMap<String, Object> templateVariables = new HashMap<>();
//			templateVariables.put("rule.name", rule.getName());
//			templateVariables.put("rule.description", rule.getDescription());
//			templateVariables.put("rule.definition", rule.getRuleDefinition());
//			templateVariables.put("packet.name", rule.getPacket().getName());
//			templateVariables.put("project", rule.getProject().getName());
//			templateVariables.put("project.description", rule.getProject().getDescription());
            // TODO: choose whether to expose only a specific fields subset (see above) or
            // the whole objects
            templateVariables.put("rule", rule);
            templateVariables.put("packet", rule.getPacket());
            templateVariables.put("project", rule.getProject());
            templateVariables.put(RULE_NAME_PLACEHOLDER, rule.getName());
            templateVariables.put(RULE_DESCRIPTION_PLACEHOLDER, rule.getDescription());
            String mailBody =
                mailService.generateTextFromStringTemplate(decodeBase64String(body), templateVariables);
            try {
                mailService.sendMail(mailSender, recipientList, ccRecipientList,
                    new ArrayList<>(), decodeBase64String(subject), mailBody, null);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private String decodeBase64String(String base64String) {
        Base64.Decoder dec = Base64.getDecoder();
        return new String(dec.decode(base64String));
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCcRecipients() {
        return ccRecipients;
    }

    public void setCcRecipients(String ccRecipients) {
        this.ccRecipients = ccRecipients;
    }
}
