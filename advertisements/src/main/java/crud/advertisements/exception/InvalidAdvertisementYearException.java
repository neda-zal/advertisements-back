package crud.advertisements.exception;

public class InvalidAdvertisementYearException extends RuntimeException {
  public InvalidAdvertisementYearException() {
    super("Advertisement's year should not be in the future");
  }
}
