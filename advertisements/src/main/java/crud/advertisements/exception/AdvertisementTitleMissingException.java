package crud.advertisements.exception;

public class AdvertisementTitleMissingException extends RuntimeException {
  public AdvertisementTitleMissingException() {
    super("Advertisement title should not be empty");
  }
}
