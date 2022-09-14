package it.acsoftware.hyperiot.hpacket.model;

public enum HPacketTrafficPlan {

    LOW("low"), MEDIUM("medium"), HIGH("high"), INTENSIVE("intensive");

    private String name;

    HPacketTrafficPlan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
