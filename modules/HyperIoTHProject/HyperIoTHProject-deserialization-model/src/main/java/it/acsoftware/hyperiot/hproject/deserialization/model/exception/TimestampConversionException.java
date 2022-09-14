package it.acsoftware.hyperiot.hproject.deserialization.model.exception;

public class TimestampConversionException extends Exception {
    public TimestampConversionException() {
    }

    public TimestampConversionException(String message) {
        super(message);
    }

    public TimestampConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimestampConversionException(Throwable cause) {
        super(cause);
    }

    public TimestampConversionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
