package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Profile("dev")
@Repository
public interface BudgetRepositoryMongo extends BudgetRepository, MongoRepository<Budget, String> {

}
