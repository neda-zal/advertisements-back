package crud.advertisements.service;

import crud.advertisements.dto.AdvertisementDto;
import crud.advertisements.exception.AdvertisementNotFoundException;
import crud.advertisements.exception.AdvertisementTitleMissingException;
import crud.advertisements.exception.AdvertisementYearMissingException;
import crud.advertisements.exception.InvalidAdvertisementMileageException;
import crud.advertisements.exception.InvalidAdvertisementPriceException;
import crud.advertisements.exception.InvalidAdvertisementTitleException;
import crud.advertisements.exception.InvalidAdvertisementYearException;
import crud.advertisements.model.Advertisement;
import crud.advertisements.repository.AdvertisementRepository;
import java.time.Instant;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdvertisementService {

  private final AdvertisementRepository advertisementRepository;

  public Page<Advertisement> getAll(Pageable pageable) {
    return this.advertisementRepository.findAll(pageable);
  }

  public Advertisement getAdvertisement(String id) {
    return this.advertisementRepository.findById(id)
        .orElseThrow(() -> new AdvertisementNotFoundException(id));
  }

  public Advertisement createOne(AdvertisementDto advertisementDto) {
    // validation
    this.validateAdvertisement(advertisementDto);

    return this.advertisementRepository.save(new Advertisement(advertisementDto));
  }

  public Advertisement updateOne(String id, AdvertisementDto advertisementDto) {
    Advertisement advertisement = this.advertisementRepository.findById(id)
        .orElseThrow(() -> new AdvertisementNotFoundException(id));

    // validation
    this.validateAdvertisement(advertisementDto);

    advertisement.replaceWithNew(advertisementDto);

    return this.advertisementRepository.save(advertisement);
  }

  public void deleteAdvertisement(String id) {
    if (!this.advertisementRepository.existsById(id)) {
      throw new AdvertisementNotFoundException(id);
    }
    this.advertisementRepository.deleteById(id);
  }

  private void validateAdvertisement(AdvertisementDto advertisementDto) {
    this.validateTitle(advertisementDto.getTitle());
    this.validatePrice(advertisementDto.getPrice());
    this.validateYear(advertisementDto.getYear());
    this.validateMileage(advertisementDto.getMileage());
  }

  private void validateTitle(String title) {
    if (title == null || title.isEmpty()) {
      throw new AdvertisementTitleMissingException();
    }
    if (title.length() < 4) {
      throw new InvalidAdvertisementTitleException(4);
    }
  }

  private void validatePrice(double price) {
    if (price <= 0 || price > 1_000_000_000) {
      throw new InvalidAdvertisementPriceException();
    }
  }

  private void validateYear(Date year) {
    if (year == null) {
      throw new AdvertisementYearMissingException();
    }
    Date now = Date.from(Instant.now());
    if (year.equals(now) || year.after(now)) {
      throw new InvalidAdvertisementYearException();
    }
  }

  private void validateMileage(int mileage) {
    if (mileage <= 0 || mileage > 1_000_000_000) {
      throw new InvalidAdvertisementMileageException();
    }
  }

}