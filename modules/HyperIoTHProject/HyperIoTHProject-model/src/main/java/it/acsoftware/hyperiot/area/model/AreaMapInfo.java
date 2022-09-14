package it.acsoftware.hyperiot.area.model;

import javax.persistence.Embeddable;

@Embeddable
public class AreaMapInfo {
    private String icon;
    private Double x;
    private Double y;
    private Double z;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }
}
