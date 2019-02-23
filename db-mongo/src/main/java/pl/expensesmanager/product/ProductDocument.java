package pl.expensesmanager.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductDocument {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}
