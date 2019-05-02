package pl.em.order;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderMongoRepository extends MongoRepository<OrderDocument, String> {

}
