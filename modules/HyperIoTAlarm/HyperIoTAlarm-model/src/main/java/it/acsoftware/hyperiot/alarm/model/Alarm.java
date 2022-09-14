package it.acsoftware.hyperiot.alarm.model;

import com.fasterxml.jackson.annotation.JsonView;
import it.acsoftware.hyperiot.alarm.event.model.AlarmEvent;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTProtectedEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTJSONView;
import it.acsoftware.hyperiot.base.validation.NoMalitiusCode;
import it.acsoftware.hyperiot.base.validation.NotNullOnPersist;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Aristide Cittadino Model class for Alarm of HyperIoT platform. This
 * class is used to map Alarm with the database.
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Alarm extends HyperIoTAbstractEntity implements HyperIoTProtectedEntity {

    @JsonView({HyperIoTJSONView.Public.class, HyperIoTJSONView.Compact.class})
    private String name;

    @JsonView({HyperIoTJSONView.Public.class, HyperIoTJSONView.Compact.class})
    private boolean inhibited;

    @JsonView({HyperIoTJSONView.Public.class})
    private List<AlarmEvent> alarmEventList;

    public Alarm(){
        this.alarmEventList = new ArrayList<>();
    }

    @NoMalitiusCode
    @NotNullOnPersist
    @NotEmpty
    @Size( max = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInhibited() {
        return inhibited;
    }

    public void setInhibited(boolean inhibited) {
        this.inhibited = inhibited;
    }

    @OneToMany(mappedBy = "alarm", targetEntity = AlarmEvent.class, fetch = FetchType.EAGER)
    public List<AlarmEvent> getAlarmEventList() {
        return alarmEventList;
    }

    public void setAlarmEventList(List<AlarmEvent> alarmEventList) {
        this.alarmEventList = alarmEventList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alarm alarm = (Alarm) o;
        return name.equals(alarm.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "name='" + name + '\'' +
                ", inhibited=" + inhibited +
                '}';
    }

}