package dev.dheeraj.showtime.exception;

public class AuditoriumNotFoundException extends RuntimeException {
    public AuditoriumNotFoundException(String message) {
        super(message);
    }
}
