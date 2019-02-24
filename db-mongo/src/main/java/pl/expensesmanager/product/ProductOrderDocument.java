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
@Document(collection = "productOrder")
public class ProductOrderDocument {
	
	private String id;
	
	private Product product;
	
	private Integer quanity;
	
}
