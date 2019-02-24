package pl.expensesmanager.budget;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Profile("dev")
@Repository
public interface BudgetRepositoryMongo extends MongoRepository<BudgetDocument, String> {
	
	/**
	 * Method to find budget by name.
	 *
	 * @param name - the name of budget
	 * @return found budget as optional
	 */
	Optional<BudgetDocument> findByName(String name);
	
	/**
	 * Method to find budgets by budget value.
	 *
	 * @param budgetValue - budget value
	 * @return found budgets objects
	 */
	List<BudgetDocument> findByBudgetValue(Double budgetValue);
	
	/**
	 * Method to find budgets between budget value range.
	 *
	 * @param min - minimal budget value
	 * @param max - maximal budget value
	 * @return found budget objects
	 */
	List<BudgetDocument> findByBudgetValueBetween(Double min, Double max);
	
	/**
	 * Method to find budgets bigger than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<BudgetDocument> findByBudgetValueGreaterThan(Double budgetValue);
	
	/**
	 * Method to find budgets less than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<BudgetDocument> findByBudgetValueLessThan(Double budgetValue);
	
}
