package it.acsoftware.hyperiot.area.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.acsoftware.hyperiot.area.model.AreaDevice;
import it.acsoftware.hyperiot.hproject.model.HProjectExportInheritedFieldMixin;

import java.util.Collection;

public abstract class HProjectExportAreaMixin extends HProjectExportInheritedFieldMixin {

    @JsonProperty
    private Collection<AreaDevice> areaDevices;

}
