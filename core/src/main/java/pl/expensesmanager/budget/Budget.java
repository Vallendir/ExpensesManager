package pl.expensesmanager.budget;

import lombok.*;
import pl.expensesmanager.billofsale.BillOfSalePort;

import java.util.List;

/**
 * Representation of Budget.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Budget extends BudgetPort.BaseModel implements BudgetPort {
	
	private String name;
	
	@Setter(AccessLevel.NONE)
	private Double budgetValue;
	
	private List<BillOfSalePort> billsOfSaleList;
	
	@Override
	public Double budgetSpent() {
		return billsOfSaleList.stream()
		                      .mapToDouble(BillOfSalePort::finalPrice)
		                      .summaryStatistics()
		                      .getSum();
	}
	
	@Override
	public Double budgetLeft() {
		return budgetValue - budgetSpent();
	}
	
}
