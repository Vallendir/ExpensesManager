package pl.expensesmanager.product;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public interface ProductOrderRepositoryMongo extends ProductOrderRepository, MongoRepository<ProductOrder, String> {

}
