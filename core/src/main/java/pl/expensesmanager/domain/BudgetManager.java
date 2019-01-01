package pl.expensesmanager.domain;

import lombok.*;

import java.util.List;

/**
 * Representation of Budget.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BudgetManager extends BaseModel implements BudgetManagerApi {
	
	private List<BillOfSaleApi> billsOfSaleList;
	
	private BudgetApi budget;
	
	@Override
	public Double budgetSpent() {
		return billsOfSaleList.stream()
		                      .mapToDouble(BillOfSaleApi::finalPrice)
		                      .summaryStatistics()
		                      .getSum();
	}
	
	@Override
	public Double budgetLeft() {
		return budget.getBudgetValue() - budgetSpent();
	}
	
}
