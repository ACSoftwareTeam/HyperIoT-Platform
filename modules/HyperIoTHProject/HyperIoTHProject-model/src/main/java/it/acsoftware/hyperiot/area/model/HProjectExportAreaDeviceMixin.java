package it.acsoftware.hyperiot.area.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.acsoftware.hyperiot.hdevice.model.HDevice;
import it.acsoftware.hyperiot.hproject.model.HProjectExportInheritedFieldMixin;

public abstract class HProjectExportAreaDeviceMixin extends HProjectExportInheritedFieldMixin {

    @JsonBackReference
    public abstract Area getArea();

    @JsonSerialize(using = HProjectExportInnerDeviceInAreaDeviceSerializer.class)
    public abstract HDevice getDevice();


}
