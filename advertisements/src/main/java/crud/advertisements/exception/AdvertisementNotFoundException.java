package crud.advertisements.exception;

public class AdvertisementNotFoundException extends RuntimeException {
  public AdvertisementNotFoundException(String id) {
    super("Could not find Advertisement with given id: " + id);
  }
}
