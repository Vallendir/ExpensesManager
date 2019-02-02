package pl.expensesmanager.budget;

import pl.expensesmanager.base.BaseModelPort;
import pl.expensesmanager.billofsale.BillOfSalePort;

import java.util.List;

/**
 * Interface repsentate Budget. Should be implemented in any place where is created other representation of Budget like DTOs etc.
 */
public interface BudgetPort extends BaseModelPort {
	
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
	
	/**
	 * Method to set the budget value.
	 *
	 * @param budgetValue budget value
	 */
	void setBudgetValue(Double budgetValue);
	
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
	
	/**
	 * Method to get the bills of sale list of budget.
	 *
	 * @return products list
	 */
	List<BillOfSalePort> getBillsOfSaleList();
	
	/**
	 * Method to set the bills of sale list of budget.
	 *
	 * @param billsOfSaleList products list
	 */
	void setBillsOfSaleList(List<BillOfSalePort> billsOfSaleList);
	
}
