package it.acsoftware.hyperiot.hproject.model;

import it.acsoftware.hyperiot.hpacket.model.HPacket;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AutoRegisterProjectRequest {

    private String cipherTextChallenge;
    private long projectId;
    private List<HPacket> packets;
    

    @NotNull
    public String getCipherTextChallenge() {
        return cipherTextChallenge;
    }

    public void setCipherTextChallenge(String cipherTextChallenge) {
        this.cipherTextChallenge = cipherTextChallenge;
    }

    @NotNull
    public List<HPacket> getPackets() {
        return packets;
    }

    public void setPackets(List<HPacket> packets) {
        this.packets = packets;
    }

    @NotNull
    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
