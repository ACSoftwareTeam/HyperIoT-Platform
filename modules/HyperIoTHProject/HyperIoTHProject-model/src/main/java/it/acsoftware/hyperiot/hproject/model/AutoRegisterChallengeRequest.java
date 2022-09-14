package it.acsoftware.hyperiot.hproject.model;

import javax.validation.constraints.NotNull;

public class AutoRegisterChallengeRequest {

    private String plainTextChallenge;

    @NotNull
    public String getPlainTextChallenge() {
        return plainTextChallenge;
    }

    public void setPlainTextChallenge(String plainTextChallene) {
        this.plainTextChallenge = plainTextChallene;
    }

}
