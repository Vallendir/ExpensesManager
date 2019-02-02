package pl.expensesmanager.budget;

import lombok.NoArgsConstructor;
import pl.expensesmanager.base.BaseModelNullObject;
import pl.expensesmanager.billofsale.BillOfSalePort;

import java.util.Collections;
import java.util.List;

/**
 * Representation of Budget null object pattern.
 */
@NoArgsConstructor
final class BudgetNullObject extends BaseModelNullObject implements BudgetPort {
	
	@Override
	public String getName() {
		return "NAME_of_null_object";
	}
	
	@Override
	public void setName(String name) {
	
	}
	
	@Override
	public Double getBudgetValue() {
		return 0.0;
	}
	
	@Override
	public void setBudgetValue(Double budgetValue) {
	
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
	
}
