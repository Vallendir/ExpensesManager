package pl.em.budget;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BudgetMongoRepository extends MongoRepository<BudgetDocument, String> {

}
