package it.acsoftware.hyperiot.hproject.deserialization.model.exception;

public class TimestampFormatException extends Exception {

    public TimestampFormatException() {
    }

    public TimestampFormatException(String message) {
        super(message);
    }

    public TimestampFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimestampFormatException(Throwable cause) {
        super(cause);
    }

    public TimestampFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
