package crud.advertisements.config;


import crud.advertisements.exception.AdvertisementNotFoundException;
import crud.advertisements.exception.AdvertisementTitleMissingException;
import crud.advertisements.exception.AdvertisementYearMissingException;
import crud.advertisements.exception.InvalidAdvertisementMileageException;
import crud.advertisements.exception.InvalidAdvertisementPriceException;
import crud.advertisements.exception.InvalidAdvertisementTitleException;
import crud.advertisements.exception.InvalidAdvertisementYearException;
import crud.advertisements.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler({
      AdvertisementNotFoundException.class,
  })
  public ResponseEntity<ErrorResponse> notFound(Exception ex) {
    log.warn(ex.getMessage());
    return new ResponseEntity<>(
        new ErrorResponse(
            "The Resource was not found", 404, ex.getMessage(), new DateTime().getMillis()),
        HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
      AdvertisementTitleMissingException.class,
      AdvertisementYearMissingException.class
  })
  public ResponseEntity<ErrorResponse> missingAttribute(Exception ex) {
    log.warn(ex.getMessage());
    return new ResponseEntity<>(
        new ErrorResponse(
            "Missing Required Attribute in Body", 400, ex.getMessage(), new DateTime().getMillis()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
      InvalidAdvertisementTitleException.class,
      InvalidAdvertisementPriceException.class,
      InvalidAdvertisementYearException.class,
      InvalidAdvertisementMileageException.class
  })
  public ResponseEntity<ErrorResponse> invalidInput(RuntimeException ex) {
    log.error(ex.getMessage(), ex);
    return new ResponseEntity<>(
        new ErrorResponse("Invalid input.", 400, ex.getMessage(), new DateTime().getMillis()),
        HttpStatus.BAD_REQUEST);
  }

}
