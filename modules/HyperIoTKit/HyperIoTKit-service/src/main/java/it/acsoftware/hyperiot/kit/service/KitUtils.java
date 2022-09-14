package it.acsoftware.hyperiot.kit.service;

import it.acsoftware.hyperiot.base.exception.HyperIoTRuntimeException;
import it.acsoftware.hyperiot.kit.model.Kit;

public class KitUtils {

    public final static long SYSTEM_KIT_PROJECT_ID=0;

    public static boolean isSystemKit(Kit kit){
        if(kit==null){
            throw new HyperIoTRuntimeException();
        }
        return kit.getProjectId() == SYSTEM_KIT_PROJECT_ID;
    }
}
