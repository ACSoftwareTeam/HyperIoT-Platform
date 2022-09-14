package it.acsoftware.hyperiot.hproject.api.hbase;

import it.acsoftware.hyperiot.base.api.HyperIoTBaseSystemApi;
import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithmHBaseResult;
import it.acsoftware.hyperiot.hproject.model.hbase.HPacketCount;
import it.acsoftware.hyperiot.hproject.model.hbase.timeline.TimelineColumnFamily;
import it.acsoftware.hyperiot.hproject.model.hbase.timeline.TimelineElement;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface HProjectHBaseSystemApi extends HyperIoTBaseSystemApi {

    /**
     * Given an HProject ID and a list of HPacket IDs inside it, this method scan Avro HPackets between a start time
     * and an end time, stored in an HBase table.
     * @param hProjectId HProject ID
     * @param hPacketIds HPacket list
     * @param hDeviceIds HDevice list
     * @param alarmState Alarm State
     * @param rowKeyLowerBound Scanning start time (i.e. an HBase row key)
     * @param rowKeyUpperBound Scanning end time (i.e. an HBase row key)
     * @param outputStream Stream on which it sends data
     * @throws IOException IOException
     */
    void scanHProject(long hProjectId, List<String> hPacketIds, List<String> hDeviceIds, long rowKeyLowerBound, long rowKeyUpperBound,
                      String alarmState, OutputStream outputStream)
            throws IOException;

    /**
     * It counts HPacket event number between start time and end time, depending on pagination delta,
     * which must be lower or equal than HBase max scan page size
     * @param projectId HProject ID
     * @param packetIds List of HPacket IDs, which count event number for
     * @param deviceIds List of HDevice IDs, which count event number for
     * @param startTime Scanning start time
     * @param endTime Scanning end time
     * @return A list of HPacketCount
     * @throws IOException IOException
     * @throws ParseException ParseException
     */
    List<HPacketCount> timelineEventCount(long projectId, List<String> packetIds, List<String> deviceIds, long startTime, long endTime)
            throws Throwable;

    /**
     * Service scans and returns data from timeline table
     * @param tableName Table name
     * @param packetIds Packet IDs
     * @param deviceIds Device IDs
     * @param step Step
     * @param startTime Timeline start time
     * @param endTime Timeline end time
     * @param timezone Timezone of client which has invoked the method, i.e. Europe/Rome
     * @return TimelineElement list
     * @throws Exception Exception
     */
    List<TimelineElement> timelineScan(String tableName, List<String> packetIds, List<String> deviceIds, TimelineColumnFamily step,
                                       long startTime, long endTime, String timezone)
            throws Exception;

    /**
     * It returns output of algorithm which has been defined for a project
     * @param projectId Project ID
     * @param hProjectAlgorithmId HProjectAlgorithm ID
     * @return HProjectAlgorithmHBaseResult
     */
    HProjectAlgorithmHBaseResult getAlgorithmOutputs(long projectId, long hProjectAlgorithmId) throws IOException;


}
