package crud.advertisements.exception;

public class InvalidAdvertisementTitleException extends RuntimeException {
  public InvalidAdvertisementTitleException(int size) {
    super("Advertisement title should be longer than: " + size + " characters");
  }
}
