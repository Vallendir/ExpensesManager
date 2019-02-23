package pl.expensesmanager.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryMongo extends ProductRepository, MongoRepository<ProductPort, String> {

}
