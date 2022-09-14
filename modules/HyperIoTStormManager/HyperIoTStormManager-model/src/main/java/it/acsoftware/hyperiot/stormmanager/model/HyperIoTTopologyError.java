package it.acsoftware.hyperiot.stormmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class HyperIoTTopologyError {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMessage;
    @JsonIgnore
    private String stackTrace;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public static HyperIoTTopologyError.HyperIoTTopologyErrorBuilder builder() {
        return new HyperIoTTopologyError.HyperIoTTopologyErrorBuilder();
    }

    public static class HyperIoTTopologyErrorBuilder {

        private HyperIoTTopologyError hyperIoTTopologyError;

        public HyperIoTTopologyErrorBuilder() {
            hyperIoTTopologyError = new HyperIoTTopologyError();
        }

        public HyperIoTTopologyErrorBuilder errorType(String errorType) {
            hyperIoTTopologyError.setErrorType(errorType);
            return this;
        }

        public HyperIoTTopologyErrorBuilder errorMessage(String errorMessage) {
            hyperIoTTopologyError.setErrorMessage(errorMessage);
            return this;
        }

        public HyperIoTTopologyErrorBuilder stackTrace(String stackTrace) {
            hyperIoTTopologyError.setStackTrace(stackTrace);
            return this;
        }

        public HyperIoTTopologyError build() {
            return hyperIoTTopologyError;
        }

    }

}
