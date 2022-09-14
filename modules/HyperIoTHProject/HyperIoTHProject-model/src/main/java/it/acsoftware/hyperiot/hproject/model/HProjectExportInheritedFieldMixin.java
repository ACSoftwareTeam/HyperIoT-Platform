package it.acsoftware.hyperiot.hproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public abstract class HProjectExportInheritedFieldMixin {

    @JsonIgnore
    public abstract Date getEntityCreateDate() ;

    @JsonIgnore
    public abstract Date getEntityModifyDate();
}
