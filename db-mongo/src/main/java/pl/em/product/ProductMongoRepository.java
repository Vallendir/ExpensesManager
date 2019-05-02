package pl.em.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductMongoRepository extends MongoRepository<ProductDocument, String> {

}
