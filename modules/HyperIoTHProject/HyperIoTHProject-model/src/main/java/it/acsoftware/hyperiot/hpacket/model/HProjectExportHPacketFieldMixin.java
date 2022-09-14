package it.acsoftware.hyperiot.hpacket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.acsoftware.hyperiot.hproject.model.HProjectExportInheritedFieldMixin;

public  abstract class HProjectExportHPacketFieldMixin extends HProjectExportInheritedFieldMixin {


    @JsonIgnore
    public abstract Object getValue();
}
