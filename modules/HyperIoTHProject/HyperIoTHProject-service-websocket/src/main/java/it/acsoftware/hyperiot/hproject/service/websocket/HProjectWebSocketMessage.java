package it.acsoftware.hyperiot.hproject.service.websocket;

import it.acsoftware.hyperiot.websocket.model.message.HyperIoTWebSocketMessage;
import it.acsoftware.hyperiot.websocket.model.message.HyperIoTWebSocketMessageType;

import java.util.Date;

public class HProjectWebSocketMessage extends HyperIoTWebSocketMessage {
    private byte[] key;

    @Override
    public String getCmd() {
        return super.getCmd();
    }

    @Override
    public byte[] getPayload() {
        return super.getPayload();
    }

    @Override
    public Date getTimestamp() {
        return super.getTimestamp();
    }

    @Override
    public HyperIoTWebSocketMessageType getType() {
        return super.getType();
    }

    @Override
    public String getContentType() {
        return super.getContentType();
    }

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public static HProjectWebSocketMessage createMessage(String cmd, byte[] payload,byte[] key, HyperIoTWebSocketMessageType type){
        HProjectWebSocketMessage m = new HProjectWebSocketMessage();
        m.setTimestamp(new Date());
        m.setCmd(cmd);
        m.setPayload(payload);
        m.setType(type);
        m.setKey(key);
        return m;
    }
}
