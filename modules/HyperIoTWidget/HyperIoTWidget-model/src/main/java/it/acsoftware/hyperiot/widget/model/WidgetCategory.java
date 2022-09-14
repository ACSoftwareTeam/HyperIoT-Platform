package it.acsoftware.hyperiot.widget.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WidgetCategory {
    ALL(0, "all", "icon-hyt_layout"),
    BAR(1, "bar-chart", "icon-hyt_chartBar"),
    LINE(2, "line-chart", "icon-hyt_chartLine"),
    PIE(3, "pie-chart", "icon-hyt_charCake"),
    RADAR(4, "radar-chart", "icon-hyt_chartRadar"),
    GAUGES(5, "gauges", "icon-hyt_chartGauge"),
    MAP(6, "map", "icon-hyt_map"),
    ACTION(7, "action","icon-hyt_action"),
    TABLES(8, "tables", "icon-hyt_tableBig");

    private int id;
    private String name;
    private String fontIcon;

    WidgetCategory(int id, String name, String fontIcon) {
        this.id = id;
        this.name = name;
        this.fontIcon = fontIcon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFontIcon() {
        return fontIcon;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
