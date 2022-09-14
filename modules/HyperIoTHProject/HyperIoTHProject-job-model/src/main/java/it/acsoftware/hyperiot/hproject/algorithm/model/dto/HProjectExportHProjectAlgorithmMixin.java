package it.acsoftware.hyperiot.hproject.algorithm.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import it.acsoftware.hyperiot.algorithm.model.Algorithm;
import it.acsoftware.hyperiot.hproject.model.HProject;
import it.acsoftware.hyperiot.hproject.model.HProjectExportInheritedFieldMixin;

public abstract class HProjectExportHProjectAlgorithmMixin extends HProjectExportInheritedFieldMixin {

    @JsonIgnore
    public abstract HProject getProject();

    @JsonSerialize(using = HProjectExportInnerAlgorithmSerializer.class)
    public abstract Algorithm getAlgorithm();
}
