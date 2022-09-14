package it.acsoftware.hyperiot.algorithm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import it.acsoftware.hyperiot.base.api.entity.HyperIoTProtectedEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTAbstractEntity;
import it.acsoftware.hyperiot.base.model.HyperIoTJSONView;
import it.acsoftware.hyperiot.base.validation.NoMalitiusCode;
import it.acsoftware.hyperiot.base.validation.NotNullOnPersist;
import it.acsoftware.hyperiot.base.validation.ValidClassname;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Aristide Cittadino Model class for Algorithm of HyperIoT platform. This
 *         class is used to map Algorithm with the database.
 *
 */

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Algorithm extends HyperIoTAbstractEntity implements HyperIoTProtectedEntity {

    /**
     * Name of algorithm
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String name;
    /**
     * Description of algorithm
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String description;
    /**
     * String, in JSON format, containing base configuration of algorithm (i.e. inputs and outputs)
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String baseConfig;
    /**
     * Name of Spark job jar file
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String jarName;

    /**
     * Jar path
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String jarPath;

    /**
     * Name of class containing Spark job main method
     */
    @JsonView(HyperIoTJSONView.Public.class)
    private String mainClassname;

    /**
     * Get name of algorithm
     * @return name of algorithm
     */
    @NoMalitiusCode
    @NotNullOnPersist
    @NotEmpty
    @Size(max = 255)
    public String getName() {
        return name;
    }

    /**
     * Set name of algorithm
     * @param name name of algorithm
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get description of algorithm
     * @return description of algorithm
     */
    @NoMalitiusCode
    @Column(length = 3000)
    @Size(max = 3000)
    public String getDescription() {
        return description;
    }

    /**
     * Set description of algorithm
     * @param description description of algorithm
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get base configuration of algorithm
     * @return base configuration of algorithm
     */
    @NoMalitiusCode
    @NotNullOnPersist
    @NotEmpty
    @Column(columnDefinition = "TEXT")
    public String getBaseConfig() {
        return baseConfig;
    }

    /**
     * Set base configuration of algorithm
     * @param baseConfig base configuration of algorithm
     */
    public void setBaseConfig(String baseConfig) {
        this.baseConfig = baseConfig;
    }

    /**
     * Get name of Spark job jar file
     * @return name of Spark job jar file
     */
    @NoMalitiusCode
    @Length(max = 500)
    public String getJarName() {
        return jarName;
    }

    /**
     * Set name of Spark job jar file
     * @param jarName name of Spark job jar file
     */
    public void setJarName(String jarName) {
        this.jarName = jarName;
    }

    @NoMalitiusCode
    @Length(max = 1000)
    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    /**
     * Return name of class containing Spark job main method
     * @return name of class containing Spark job main method
     */
    @NoMalitiusCode
    @ValidClassname
    public String getMainClassname() {
        return mainClassname;
    }

    /**
     * Set name of class containing Spark job main method
     * @param mainClassname name of class containing Spark job main method
     */
    public void setMainClassname(String mainClassname) {
        this.mainClassname = mainClassname;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Algorithm other = (Algorithm) obj;
        if (this.getId() > 0 && other.getId() > 0)
            return this.getId() == other.getId();
        if (name == null) {
            return other.name == null;
        } else return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Algorithm{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", baseConfig='" + baseConfig + '\'' +
                '}';
    }

}
