package it.acsoftware.hyperiot.storm.hbase.mapper;

import it.acsoftware.hyperiot.storm.util.StormConstants;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.storm.hbase.bolt.mapper.HBaseMapper;
import org.apache.storm.hbase.common.ColumnList;
import org.apache.storm.tuple.Tuple;

import static org.apache.storm.hbase.common.Utils.toBytes;
/**
 * @Author Francesco Salerno.
 * Custom HBaseMapper to write on <EVENT_RULE_STATE_TABLE_NAME_PREFIX><hprojectID> table.
 * This table keep track of the event's rule state (generically event and alarm event).
 */
public class EventRuleStateHBaseMapper implements HBaseMapper {

    private String rowKeyField;

    private byte[] columnFamily;

    @Override
    public byte[] rowKey(Tuple tuple) {
        Object objVal = tuple.getValueByField(this.rowKeyField);
        return toBytes(objVal);
    }

    @Override
    public ColumnList columns(Tuple tuple) {
        long eventRuleId = (long) tuple.getValueByField(StormConstants.EVENT_RULE_ID);
        String cellValue = (String) tuple.getValueByField(StormConstants.EVENT_RULE_STATE_INFO_FIELD);
        ColumnList cols = new ColumnList();
        cols.addColumn(this.columnFamily, Bytes.toBytes(eventRuleId), toBytes(cellValue));
        return cols;
    }

    /**
     * This is a config method, it is called in topology.yaml file and set HBase column family
     * @param columnFamily HBase column family
     * @return AlarmEventRuleStateHBaseMapper
     */
    public EventRuleStateHBaseMapper withColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily.getBytes();
        return this;
    }

    /**
     * This is a config method, it is called in topology.yaml file and set tuple field containing
     * HBase row key
     * @param rowKeyField Tuple field containing HBase row key
     * @return AlarmEventRuleStateHBaseMapper
     */
    public EventRuleStateHBaseMapper withRowKeyField(String rowKeyField) {
        this.rowKeyField = rowKeyField;
        return this;
    }
}
