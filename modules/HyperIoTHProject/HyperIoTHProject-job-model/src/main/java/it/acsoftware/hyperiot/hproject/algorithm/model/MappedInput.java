package it.acsoftware.hyperiot.hproject.algorithm.model;

import it.acsoftware.hyperiot.algorithm.model.AlgorithmIOField;

public class MappedInput {

    private long packetFieldId;
    private AlgorithmIOField algorithmInput;

    public long getPacketFieldId() {
        return packetFieldId;
    }

    public void setPacketFieldId(long packetFieldId) {
        this.packetFieldId = packetFieldId;
    }

    public AlgorithmIOField getAlgorithmInput() {
        return algorithmInput;
    }

    public void setAlgorithmInput(AlgorithmIOField algorithmInput) {
        this.algorithmInput = algorithmInput;
    }

}
