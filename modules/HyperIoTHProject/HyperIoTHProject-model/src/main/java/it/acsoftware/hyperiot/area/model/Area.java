package it.acsoftware.hyperiot.area.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.acsoftware.hyperiot.base.api.HyperIoTOwnedChildResource;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTBaseEntity;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTProtectedEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTInnerEntityJSONSerializer;
import it.acsoftware.hyperiot.base.model.HyperIoTJSONView;
import it.acsoftware.hyperiot.base.validation.NoMalitiusCode;
import it.acsoftware.hyperiot.base.validation.NotNullOnPersist;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.hproject.model.HProjectJSONView;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

/**
 * @author Aristide Cittadino Model class for Area of HyperIoT platform. This
 * class is used to map the concept of Area which aggregates devices.
 */

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "project_id", "parentArea_id"})})
public class Area extends HyperIoTAbstractEntity
        implements HyperIoTProtectedEntity, HyperIoTOwnedChildResource {

    /**
     * Area name
     */
    @JsonView({HProjectJSONView.Export.class,HyperIoTJSONView.Extended.class,HyperIoTJSONView.Public.class,HyperIoTJSONView.Compact.class})
    private String name;

    /**
     * Area description
     */
    @JsonView({HProjectJSONView.Export.class,HyperIoTJSONView.Extended.class,HyperIoTJSONView.Public.class,HyperIoTJSONView.Compact.class})
    private String description;

    /**
     * Area related project
     */
    private HProject project;

    /**
     * Area devices (for visual devices map)
     */
    @JsonIgnore
    private Collection<AreaDevice> areaDevices;
    @JsonView({HyperIoTJSONView.Extended.class,HyperIoTJSONView.Public.class,HyperIoTJSONView.Compact.class})
    private String imagePath;

    @JsonView({HProjectJSONView.Export.class,HyperIoTJSONView.Extended.class,HyperIoTJSONView.Public.class,HyperIoTJSONView.Compact.class})
    private AreaMapInfo mapInfo;

    /**
     * Parent area
     */
    @JsonView({HProjectJSONView.Export.class,HyperIoTJSONView.Extended.class,HyperIoTJSONView.Public.class,HyperIoTJSONView.Compact.class})
    private Area parentArea;

    /**
     * Inner areas
     */
    @JsonView({HyperIoTJSONView.Extended.class,HProjectJSONView.Export.class})
    private Set<Area> innerArea;

    /**
     * @return Area name
     */
    @NotNullOnPersist
    @NotEmpty
    @NoMalitiusCode
    @Size( max = 255)
    public String getName() {
        return name;
    }

    /**
     * @param name Area name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Area description
     */
    @NoMalitiusCode
    @Column(length = 3000)
    @Size( max = 3000)
    public String getDescription() {
        return description;
    }

    /**
     * @param description Area description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Area related project
     */
    @NotNullOnPersist
    @ManyToOne(targetEntity = HProject.class)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public HProject getProject() {
        return project;
    }

    /**
     * @param project Area related project
     */
    public void setProject(HProject project) {
        this.project = project;
    }

    @Override
    @Transient
    @JsonIgnore
    public HyperIoTBaseEntity getParent() {
        return this.project;
    }

    /**
     * @return Area Devices
     */
    @OneToMany(targetEntity = AreaDevice.class, mappedBy = "area", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    public Collection<AreaDevice> getAreaDevices() {
        return areaDevices;
    }

    /**
     * @param areaDevices devices contained inside the area
     */
    public void setAreaDevices(Collection<AreaDevice> areaDevices) {
        this.areaDevices = areaDevices;
    }

    /**
     * Gets image path of this area map.
     * @return the area image path
     */
    @NoMalitiusCode
    @Size( max = 255)
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Sets image path of this area map.
     * @param imagePath Area image path.
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Gets area map info (eg. coordinates, icon and other map-related data)
     * @return map info
     */
    public AreaMapInfo getMapInfo() {
        return mapInfo;
    }

    /**
     * Sets area map info
     * @param mapInfo The AreaMapInfo object containing all map-related data
     */
    public void setMapInfo(AreaMapInfo mapInfo) {
        this.mapInfo = mapInfo;
    }

    /**
     * @return Parent Area
     */
    @JoinColumn(name = "parentArea_id")
    @ManyToOne(targetEntity = Area.class)
    @JsonBackReference
    public Area getParentArea() {
        return parentArea;
    }

    /**
     * @param parentArea
     */
    public void setParentArea(Area parentArea) {
        this.parentArea = parentArea;
    }

    /**
     * @return
     */
    @OneToMany(mappedBy = "parentArea" )
    public Set<Area> getInnerArea() {
        return innerArea;
    }

    /**
     * @param innerArea
     */
    public void setInnerArea(Set<Area> innerArea) {
        this.innerArea = innerArea;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((parentArea == null) ? 0 : parentArea.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Area other = (Area) obj;
        if (other.getId() > 0 && this.getId() > 0)
            return other.getId() == this.getId();
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (parentArea == null) {
            if (other.parentArea != null)
                return false;
        } else if (!parentArea.equals(other.parentArea))
            return false;
        if (project == null) {
            return other.project == null;
        } else return project.equals(other.project);
    }
}
