package pl.expensesmanager.domain;

/**
 * Interface repsentate Budget. Should be implemented in any place where is created other representation of Budget like DTOs etc.
 */
public interface BudgetApi {
	
	/**
	 * Method to get the name of budget.
	 *
	 * @return name of budget
	 */
	String getName();
	
	/**
	 * Method to set the name of budget.
	 *
	 * @param name name of budget
	 */
	void setName(String name);
	
	/**
	 * Method to get the budget value.
	 *
	 * @return the budget value
	 */
	Double getBudgetValue();
	
}
