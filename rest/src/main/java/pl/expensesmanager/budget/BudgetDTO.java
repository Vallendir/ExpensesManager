package pl.expensesmanager.budget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.expensesmanager.base.BaseModel;
import pl.expensesmanager.billofsale.BillOfSale;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetDTO {
	
	private String id;
	
	private String name;
	
	private Double budgetValue;
	
	private List<String> billsOfSaleIdsList;
	
	protected BudgetDTO map(Budget budget) {
		return BudgetDTO.builder()
		                .id(budget.getId())
		                .name(budget.getName())
		                .budgetValue(budget.getBudgetValue())
		                .billsOfSaleIdsList(budget.getBillsOfSaleList()
		                                          .stream()
		                                          .map(BaseModel::getId)
		                                          .collect(Collectors.toList()))
		                .build();
	}
	
	protected Budget map(BudgetDTO budgetDTO) {
		Budget budget = Budget.builder()
		                      .name(budgetDTO.getName())
		                      .budgetValue(budgetDTO.getBudgetValue())
		                      .billsOfSaleList(budgetDTO.getBillsOfSaleIdsList()
		                                                .stream()
		                                                .map(id -> {
			                                                BillOfSale billOfSale = new BillOfSale();
			                                                billOfSale.setId(id);
			
			                                                return billOfSale;
		                                                })
		                                                .collect(Collectors.toList()))
		                      .build();
		budget.setId(budgetDTO.getId());
		
		return budget;
	}
	
}
