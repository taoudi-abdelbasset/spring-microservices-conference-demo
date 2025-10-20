package com.microservice.keynote_service.expections;
import org.springframework.stereotype.Component;

@Component
public class KeynoteNotFoundException extends Exception{
    public KeynoteNotFoundException() {
        super();
    }

    public KeynoteNotFoundException(String message) {
        super(message);
    }

    public KeynoteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public KeynoteNotFoundException(Throwable cause) {
        super(cause);
    }
}
