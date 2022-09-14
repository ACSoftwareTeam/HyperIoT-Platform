package it.acsoftware.hyperiot.stormmanager.model;

import java.util.Objects;

/**
 *
 */
public class TopologyConfig {
    public String name = "";
    public String properties = "";
    public String yaml = "";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopologyConfig)) return false;
        TopologyConfig that = (TopologyConfig) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(yaml, that.yaml);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, properties, yaml);
    }
}
