package crud.advertisements.controller;

import crud.advertisements.dto.AdvertisementDto;
import crud.advertisements.model.Advertisement;
import crud.advertisements.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/api/rest/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdvertisementController {

  private final AdvertisementService advertisementService;

  @GetMapping(path = "/v1/advertisement", produces = "application/json")
  ResponseEntity<Page<Advertisement>> getAll(
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @RequestParam(value = "size", required = false, defaultValue = "20") int size) {
    return ResponseEntity.ok(
        advertisementService.getAll(PageRequest.of(page, size)));
  }

  @GetMapping(path = "/v1/advertisement/{id}", produces = "application/json")
  ResponseEntity<Advertisement> getOne(
      @PathVariable String id) {
    return ResponseEntity.ok(
        advertisementService.getAdvertisement(id));
  }

  @DeleteMapping(path = "/v1/advertisement/{id}", produces = "application/json")
  ResponseEntity<Advertisement> deleteOne(
      @PathVariable String id) {
    this.advertisementService.deleteAdvertisement(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(path = "/v1/advertisement", produces = "application/json")
  ResponseEntity<Advertisement> createOne(
      @RequestBody AdvertisementDto advertisementDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.advertisementService.createOne(advertisementDto));
  }

  @PutMapping(path = "/v1/advertisement/{id}", produces = "application/json")
  ResponseEntity<Advertisement> updateOne(
      @PathVariable String id,
      @RequestBody AdvertisementDto advertisementDto) {
    return ResponseEntity.ok(
        this.advertisementService.updateOne(id, advertisementDto));
  }

}
