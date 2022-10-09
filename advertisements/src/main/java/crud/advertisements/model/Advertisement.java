package crud.advertisements.model;

import crud.advertisements.dto.AdvertisementDto;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("advertisements")
@Getter
@Setter
@NoArgsConstructor
public class Advertisement {

  @Id
  private String id;

  private String title;

  private double price;

  private Date year;

  private int mileage;

  public Advertisement(AdvertisementDto advertisementDto) {
    this.title = advertisementDto.getTitle();
    this.price = advertisementDto.getPrice();
    this.year = advertisementDto.getYear();
    this.mileage = advertisementDto.getMileage();
  }

  public void replaceWithNew(AdvertisementDto advertisementDto) {
    this.title = advertisementDto.getTitle();
    this.price = advertisementDto.getPrice();
    this.year = advertisementDto.getYear();
    this.mileage = advertisementDto.getMileage();
  }

}
