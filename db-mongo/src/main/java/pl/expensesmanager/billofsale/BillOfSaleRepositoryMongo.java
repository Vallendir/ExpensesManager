package pl.expensesmanager.billofsale;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillOfSaleRepositoryMongo extends BillOfSaleRepository, MongoRepository<BillOfSalePort, String> {

}
