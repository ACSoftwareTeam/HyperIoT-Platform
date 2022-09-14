package it.acsoftware.hyperiot.hproject.deserialization.model.exception;

public class TimestampFieldNotFoundException extends Exception {
    public TimestampFieldNotFoundException() {
    }

    public TimestampFieldNotFoundException(String message) {
        super(message);
    }

    public TimestampFieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimestampFieldNotFoundException(Throwable cause) {
        super(cause);
    }

    public TimestampFieldNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
