package crud.advertisements.dto;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdvertisementDto {

  @NonNull
  private String title;

  private double price;

  private Date year;

  private int mileage;

}
