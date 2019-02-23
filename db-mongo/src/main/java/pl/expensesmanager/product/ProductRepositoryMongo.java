package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public interface ProductRepositoryMongo extends ProductStorePort, MongoRepository<ProductPort, String> {

}
