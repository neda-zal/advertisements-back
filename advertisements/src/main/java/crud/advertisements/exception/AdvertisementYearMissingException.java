package crud.advertisements.exception;

public class AdvertisementYearMissingException extends RuntimeException {
  public AdvertisementYearMissingException() {
    super("Advertisement year should not be null");
  }
}
