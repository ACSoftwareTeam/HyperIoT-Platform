package it.acsoftware.hyperiot.hproject.model;

public class AutoRegisterProjectCredentials {
    private String privateCert;
    private String privateKey;
    private HProject project;

    public String getPrivateCert() {
        return privateCert;
    }

    public void setPrivateCert(String privateCert) {
        this.privateCert = privateCert;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public HProject getProject() {
        return project;
    }

    public void setProject(HProject project) {
        this.project = project;
    }
}
