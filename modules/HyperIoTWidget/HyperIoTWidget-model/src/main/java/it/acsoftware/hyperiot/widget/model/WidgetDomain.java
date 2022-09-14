package it.acsoftware.hyperiot.widget.model;

public enum WidgetDomain {
    INDUSTRY_40(0, "industry-40", "outline-view_list-24px.svg"),
    SMART_FIELDS(1, "smart-fields", "outline-view_list-24px.svg"),
    HEALTH(2, "health", "outline-view_list-24px.svg"),
    IOT(3, "iot", "outline-view_list-24px.svg");

    private int id;
    private String name;
    private String icon;

    WidgetDomain(int id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}
