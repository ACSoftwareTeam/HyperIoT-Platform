package it.acsoftware.hyperiot.hproject.algorithm.model;

import java.util.List;
import java.util.Objects;

/**
 * This class maps input of Algorithm base configuration to HPacket and HPacketField instances
 */
public class HProjectAlgorithmInputField {

    /**
     * ID of HPacket
     */
    private long packetId;
    /**
     * This field maps ID of HPacketField to input, which is contained in base configuration of algorithm
     */
    private List<MappedInput> mappedInputList;

    public long getPacketId() {
        return packetId;
    }

    public void setPacketId(long packetId) {
        this.packetId = packetId;
    }

    public List<MappedInput> getMappedInputList() {
        return mappedInputList;
    }

    public void setMappedInputList(List<MappedInput> mappedInputList) {
        this.mappedInputList = mappedInputList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HProjectAlgorithmInputField that = (HProjectAlgorithmInputField) o;
        return packetId == that.packetId &&
                Objects.equals(mappedInputList, that.mappedInputList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packetId, mappedInputList);
    }

}
