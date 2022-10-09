package crud.advertisements.exception;

public class InvalidAdvertisementPriceException extends RuntimeException {
  public InvalidAdvertisementPriceException() {
    super("Advertisement price should be between 0 and 1 000 000 000");
  }
}
