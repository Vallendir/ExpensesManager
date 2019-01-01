package pl.expensesmanager.domain;

/**
 * Interface repsentate Budget manager. Should be implemented in any place where is created other representation of Budget manager like DTOs etc.
 */
public interface BudgetManagerApi {
	
	/**
	 * Method to get the budget.
	 *
	 * @return budget
	 */
	BudgetApi getBudget();
	
	/**
	 * Method to set the budget.
	 *
	 * @param budget the budget
	 */
	void setBudget(BudgetApi budget);
	
	/**
	 * Method to get the budget spent.
	 *
	 * @return budget spent
	 */
	Double budgetSpent();
	
	/**
	 * Method to get the budget left.
	 *
	 * @return budget left
	 */
	Double budgetLeft();
	
}
