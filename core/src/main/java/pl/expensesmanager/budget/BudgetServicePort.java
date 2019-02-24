package pl.expensesmanager.budget;

import pl.expensesmanager.base.BaseService;

import java.util.List;
import java.util.Optional;

interface BudgetServicePort extends BaseService<Budget, String> {
	
	/**
	 * Method to search budget by name.
	 *
	 * @param name - the name of budget
	 * @return found budget as optional
	 */
	Optional<Budget> searchByName(String name);
	
	/**
	 * Method to search budgets by budget value.
	 *
	 * @param budgetValue - budget value
	 * @return found budgets objects
	 */
	List<Budget> searchAllByValue(Double budgetValue);
	
	/**
	 * Method to search budgets between budget value range.
	 *
	 * @param min - minimal budget value
	 * @param max - maximal budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByValueRange(Double min, Double max);
	
	/**
	 * Method to search budgets bigger than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByBiggerValueThan(Double budgetValue);
	
	/**
	 * Method to search budgets less than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<Budget> searchAllByLessValueThan(Double budgetValue);
	
}
