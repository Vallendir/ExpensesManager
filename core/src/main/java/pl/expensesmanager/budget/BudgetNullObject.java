package pl.expensesmanager.budget;

import lombok.NoArgsConstructor;
import pl.expensesmanager.billofsale.BillOfSalePort;

import java.util.Collections;
import java.util.List;

/**
 * Representation of Budget null object.
 */
@NoArgsConstructor
public class BudgetNullObject implements BudgetPort {
	
	@Override
	public String getName() {
		return "NAME_null";
	}
	
	@Override
	public void setName(String name) {
	
	}
	
	@Override
	public Double getBudgetValue() {
		return 0.0;
	}
	
	@Override
	public Double budgetSpent() {
		return 0.0;
	}
	
	@Override
	public Double budgetLeft() {
		return 0.0;
	}
	
	@Override
	public List<BillOfSalePort> getBillsOfSaleList() {
		return Collections.emptyList();
	}
	
	@Override
	public void setBillsOfSaleList(List<BillOfSalePort> billsOfSaleList) {
	
	}
	
	@Override
	public String getId() {
		return "ID_null";
	}
	
	@Override
	public void setId(String id) {
	
	}
	
	@Override
	public String toString() {
		return "NULL object.";
	}
	
}
