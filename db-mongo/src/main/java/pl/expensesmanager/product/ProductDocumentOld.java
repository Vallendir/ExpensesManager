package pl.expensesmanager.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductDocumentOld {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}
