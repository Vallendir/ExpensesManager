package pl.expensesmanager.budget;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetRepositoryMongo extends BudgetRepository, MongoRepository<BudgetPort, String> {

}
