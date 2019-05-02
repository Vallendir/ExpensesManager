package pl.em.budget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "budget")
final class BudgetDocument {
	
	private String id;
	
	private String name;
	
	private Double budgetValue;
	
	private List<String> billsIdsList;
	
}