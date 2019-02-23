package pl.expensesmanager.billofsale;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public interface BillOfSaleRepositoryMongo extends BillOfSaleStorePort, MongoRepository<BillOfSalePort, String> {

}
