package it.acsoftware.hyperiot.alarm.event.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.acsoftware.hyperiot.alarm.model.Alarm;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTProtectedEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTInnerEntityJSONSerializer;
import it.acsoftware.hyperiot.base.model.HyperIoTJSONView;
import it.acsoftware.hyperiot.base.validation.NotNullOnPersist;
import it.acsoftware.hyperiot.rule.model.Rule;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 
 * @author Aristide Cittadino Model class for AlarmEvent of HyperIoT platform. This
 *         class is used to map AlarmEvent with the database.
 *
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"alarm_id", "event_id"})})
public class AlarmEvent extends HyperIoTAbstractEntity implements HyperIoTProtectedEntity {

    @JsonView({HyperIoTJSONView.Public.class})
    @JsonSerialize(using = HyperIoTInnerEntityJSONSerializer.class)
    private Alarm alarm;

    @JsonView(HyperIoTJSONView.Public.class)
    private Rule event;

    @JsonView(HyperIoTJSONView.Public.class)
    private int severity;

    @NotNullOnPersist
    @ManyToOne(targetEntity = Alarm.class)
    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @NotNullOnPersist
    @ManyToOne(targetEntity = Rule.class)
    public Rule getEvent() {
        return event;
    }

    public void setEvent(Rule event) {
        this.event = event;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }
}