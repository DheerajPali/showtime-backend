package dev.dheeraj.showtime.exception;

public class BookingLimitExceededException extends RuntimeException {
  public BookingLimitExceededException(String message) {
    super(message);
  }
}
