package dev.dheeraj.showtime.exception;

public class SelectedSeatNotAvailableException extends RuntimeException {
  public SelectedSeatNotAvailableException(String message) {
    super(message);
  }
}
