package it.acsoftware.hyperiot.alarm.service.actions;

public class NoAlarmAction extends AlarmAction implements Runnable {

    @Override
    public String droolsDefinition(String packetVariable) {
       return this.droolsAsJson();
    }

    @Override
    public void run() {
        // no action has to be done
    }

}
