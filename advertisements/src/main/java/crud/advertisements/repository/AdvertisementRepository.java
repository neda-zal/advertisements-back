package crud.advertisements.repository;

import crud.advertisements.model.Advertisement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvertisementRepository extends MongoRepository<Advertisement, String> {

}
