package pl.expensesmanager.budget;

import pl.expensesmanager.base.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface BudgetRepository extends BaseRepository<Budget, String> {
	
	/**
	 * Method to find budget by name.
	 *
	 * @param name - the name of budget
	 * @return found budget as optional
	 */
	Optional<Budget> findByName(String name);
	
	/**
	 * Method to find budgets by budget value.
	 *
	 * @param budgetValue - budget value
	 * @return found budgets objects
	 */
	List<Budget> findByBudgetValue(Double budgetValue);
	
	/**
	 * Method to find budgets between budget value range.
	 *
	 * @param min - minimal budget value
	 * @param max - maximal budget value
	 * @return found budget objects
	 */
	List<Budget> findByBudgetValueBetween(Double min, Double max);
	
	/**
	 * Method to find budgets bigger than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> findByBudgetValueGreaterThan(Double budgetValue);
	
	/**
	 * Method to find budgets less than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> findByBudgetValueLessThan(Double budgetValue);
	
	
}
