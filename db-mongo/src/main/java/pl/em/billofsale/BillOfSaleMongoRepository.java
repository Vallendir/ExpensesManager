package pl.em.billofsale;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BillOfSaleMongoRepository extends MongoRepository<BillOfSaleDocument, String> {

}
