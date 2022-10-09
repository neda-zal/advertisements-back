package crud.advertisements.exception;

public class InvalidAdvertisementMileageException extends RuntimeException {
  public InvalidAdvertisementMileageException() {
    super("Advertisement mileage should be between 0 and 1 000 000 000");
  }
}
