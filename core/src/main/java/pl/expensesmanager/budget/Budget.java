package pl.expensesmanager.budget;

import lombok.*;
import pl.expensesmanager.base.BaseModel;
import pl.expensesmanager.billofsale.BillOfSale;

import java.util.List;

/**
 * Representation of Budget.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Budget extends BaseModel {
	
	private String name;
	
	private Double budgetValue;
	
	private List<BillOfSale> billsOfSaleList;
	
	public Double budgetSpent() {
		return billsOfSaleList.stream()
		                      .mapToDouble(BillOfSale::finalPrice)
		                      .summaryStatistics()
		                      .getSum();
	}
	
	public Double budgetLeft() {
		return budgetValue - budgetSpent();
	}
	
}
