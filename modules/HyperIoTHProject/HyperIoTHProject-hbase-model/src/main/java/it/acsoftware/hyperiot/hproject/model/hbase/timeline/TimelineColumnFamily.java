package it.acsoftware.hyperiot.hproject.model.hbase.timeline;

/**
 * This enum contains column families of an HBase table, which is dedicated to timeline queries.
 * Remember: there is one table per project.
 */
public enum TimelineColumnFamily {

    YEAR("year", 0), MONTH("month", 1), DAY("day", 2), HOUR("hour", 3),
    MINUTE("minute", 4), SECOND("second", 5), MILLISECOND("millisecond", 6);

    private String name;
    private int order;

    TimelineColumnFamily(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

}
