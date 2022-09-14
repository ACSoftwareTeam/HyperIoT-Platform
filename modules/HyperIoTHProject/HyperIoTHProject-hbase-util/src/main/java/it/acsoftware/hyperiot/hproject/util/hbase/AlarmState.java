package it.acsoftware.hyperiot.hproject.util.hbase;

import java.util.stream.Stream;

/**
 * @author Francesco Salerno
 */
public enum AlarmState {

    UP("UP") ,
    DOWN ("DOWN"),
    HANDLED("HANDLED");


    private final String name;

    AlarmState(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static AlarmState fromString(String name) {
        return Stream.of(AlarmState.values())
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static boolean isValidName(String name){
        for(AlarmState alarmState : AlarmState.values()){
            if (alarmState.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

}
