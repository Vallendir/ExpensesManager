package pl.em.budget;

import lombok.*;
import pl.em.billofsale.BillOfSale;
import pl.em.common.DomainID;
import pl.em.common.DomainModel;

import java.util.List;

/**
 * Representation of Budget.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Budget extends DomainModel {
	
	private DomainID budgetId;
	
	private String name;
	
	private Double budgetValue;
	
	private List<BillOfSale> billsOfSalseList;
	
	/**
	 * Method to get the budget spent.
	 *
	 * @return budget spent
	 */
	public Double budgetSpent() {
		return billsOfSalseList.stream()
		                      .mapToDouble(BillOfSale::finalPrice)
		                      .summaryStatistics()
		                      .getSum();
	}
	
	/**
	 * Method to get the budget left.
	 *
	 * @return budget left
	 */
	public Double budgetLeft() {
		return budgetValue - budgetSpent();
	}
	
}
