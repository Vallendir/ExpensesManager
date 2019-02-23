package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public interface BudgetRepositoryMongo extends BudgetStorePort, MongoRepository<BudgetPort, String> {

}
