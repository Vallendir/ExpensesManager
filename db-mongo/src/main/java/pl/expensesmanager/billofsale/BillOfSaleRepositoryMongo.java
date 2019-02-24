package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public interface BillOfSaleRepositoryMongo extends BillOfSaleRepository, MongoRepository<BillOfSale, String> {

}
