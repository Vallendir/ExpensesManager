package pl.expensesmanager.budget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.expensesmanager.billofsale.BillOfSaleDocument;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "budget")
public class BudgetDocument {
	
	private String id;
	
	private String name;
	
	private Double budgetValue;
	
	private List<BillOfSaleDocument> billsOfSaleList;
	
}
