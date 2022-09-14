package it.acsoftware.hyperiot.storm.hbase.mapper;

import org.apache.hadoop.hbase.util.Bytes;
import org.apache.storm.hbase.bolt.mapper.HBaseMapper;
import org.apache.storm.hbase.common.ColumnList;
import org.apache.storm.tuple.Tuple;

import static it.acsoftware.hyperiot.storm.util.StormConstants.AVRO_HPACKET_FIELD;
import static it.acsoftware.hyperiot.storm.util.StormConstants.HPACKET_ID_FIELD;
import static org.apache.storm.hbase.common.Utils.toBytes;

@SuppressWarnings("unused")
public class AvroHBaseMapper implements HBaseMapper {

    // HBase Avro bolt had to receive a tuple with two fields:
    // - rowKeyField, which is set in topology.yaml config method, refers to HBase row key
    // - packet value is HPacket instance in Avro format
    private String rowKeyField;
    private byte[] columnFamily;

    @Override
    public byte[] rowKey(Tuple tuple) {
        Object objVal = tuple.getValueByField(this.rowKeyField);
        return toBytes(objVal);
    }

    @Override
    public ColumnList columns(Tuple tuple) {
        long hPacketId = (long) tuple.getValueByField(HPACKET_ID_FIELD);
        String avroHPacket = (String) tuple.getValueByField(AVRO_HPACKET_FIELD);
        ColumnList cols = new ColumnList();
        cols.addColumn(this.columnFamily, Bytes.toBytes(hPacketId), toBytes(avroHPacket));
        return cols;
    }

    /**
     * This is a config method, it is called in topology.yaml file and set HBase column family
     * @param columnFamily HBase column family
     * @return AvroHBaseMapper
     */
    public AvroHBaseMapper withColumnFamily(String columnFamily) {
        this.columnFamily = columnFamily.getBytes();
        return this;
    }

    /**
     * This is a config method, it is called in topology.yaml file and set tuple field containing
     * HBase row key
     * @param rowKeyField Tuple field containing HBase row key
     * @return AvroHBaseMapper
     */
    public AvroHBaseMapper withRowKeyField(String rowKeyField) {
        this.rowKeyField = rowKeyField;
        return this;
    }

}
