package it.acsoftware.hyperiot.hproject.algorithm.model.dto;

import it.acsoftware.hyperiot.hproject.algorithm.model.HProjectAlgorithm;
import it.acsoftware.hyperiot.hproject.model.HProject;

import java.util.LinkedList;
import java.util.List;

public class ExportProjectDTO {

    private HProject project;

    private List<HProjectAlgorithm> algorithmsList;

    public ExportProjectDTO(){
        this.algorithmsList = new LinkedList<>();
    }

    public HProject getProject() {
        return project;
    }

    public void setProject(HProject project) {
        this.project = project;
    }

    public List<HProjectAlgorithm> getAlgorithmsList() {
        return algorithmsList;
    }

    public void setAlgorithmsList(List<HProjectAlgorithm> algorithmsList) {
        this.algorithmsList = algorithmsList;
    }
}
