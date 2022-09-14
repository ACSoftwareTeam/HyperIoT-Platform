package it.acsoftware.hyperiot.mqtt.client.model;

/**
 * Author Aristide Cittadino
 * Class used to map MQTT Message outside the MQTT Broker
 */
public class HyperIoTMqttMessage {
    private String topic;
    private String message;

    public HyperIoTMqttMessage(String topic, String message) {
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;
        result = prime * result + topic.hashCode();
        result = prime * result +  message.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HyperIoTMqttMessage))
            return false;
        HyperIoTMqttMessage message = (HyperIoTMqttMessage) obj;
        return message.topic.equals(this.topic) && message.message.equals(this.message);
    }
}
