package it.acsoftware.hyperiot.hproject.algorithm.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import it.acsoftware.hyperiot.hproject.model.HProjectJSONView;

public class ImportLogMessage {

    @JsonView(HProjectJSONView.Export.class)
    private ImportLogLevel logLevel;

    @JsonView(HProjectJSONView.Export.class)
    private String message ;

    public ImportLogMessage(ImportLogLevel logLevel , String message){
        this.logLevel=logLevel;
        this.message=message;
    }

    public ImportLogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(ImportLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
