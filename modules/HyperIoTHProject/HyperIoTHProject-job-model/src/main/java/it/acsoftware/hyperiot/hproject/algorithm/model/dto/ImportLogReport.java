package it.acsoftware.hyperiot.hproject.algorithm.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import it.acsoftware.hyperiot.hproject.model.HProjectJSONView;

import java.util.LinkedList;

public class ImportLogReport {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonView(HProjectJSONView.Export.class)
    private String projectName;

    @JsonView(HProjectJSONView.Export.class)
    private ImportReportStatus importResult ;

    @JsonView(HProjectJSONView.Export.class)
    private LinkedList<ImportLogMessage> logMessageList;

    public ImportLogReport(){
        this.logMessageList= new LinkedList<>();
    }

    public void addLogMessage(ImportLogLevel level, String message){
        logMessageList.addLast(new ImportLogMessage(level, message));
    }

    public LinkedList<ImportLogMessage> getLogMessageList() {
        return logMessageList;
    }

    public void setLogMessageList(LinkedList<ImportLogMessage> logMessageList) {
        this.logMessageList = logMessageList;
    }

    public ImportReportStatus getImportResult() {
        return importResult;
    }

    public void setImportResult(ImportReportStatus importResult) {
        this.importResult = importResult;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
