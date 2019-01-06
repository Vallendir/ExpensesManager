package pl.expensesmanager.service;

import pl.expensesmanager.domain.BudgetPort;
import pl.expensesmanager.domain.ProductPort;

import java.util.List;
import java.util.Optional;

public interface BudgetServicePort extends BaseService<BudgetPort, String> {
	
	/**
	 * Method to search budget by name.
	 *
	 * @param name - the name of budget
	 * @return found budget as optional
	 */
	Optional<ProductPort> searchForName(String name);
	
	/**
	 * Method to search budgets by budget value.
	 *
	 * @param budgetValue - budget value
	 * @return found budgets objects
	 */
	List<ProductPort> searchAllForBudgetValue(Double budgetValue);
	
	/**
	 * Method to search budgets between budget value range.
	 *
	 * @param min - minimal budget value
	 * @param max - maximal budget value
	 * @return found budget objects
	 */
	List<ProductPort> searchAllForBudgetValueRange(Double min, Double max);
	
	/**
	 * Method to search budgets bigger than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<ProductPort> searchAllForBudgetValueGreater(Double budgetValue);
	
	/**
	 * Method to search budgets less than value.
	 *
	 * @param budgetValue - budget value
	 * @return found budget objects
	 */
	List<ProductPort> searchAllForBudgetValueLower(Double budgetValue);
	
}
