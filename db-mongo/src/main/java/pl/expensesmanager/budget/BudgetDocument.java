package pl.expensesmanager.budget;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.expensesmanager.billofsale.BillOfSalePort;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class BudgetDocument {
	
	private String id;
	
	private String name;
	
	private Double budgetValue;
	
	private List<BillOfSalePort> billsOfSaleList;
	
}
