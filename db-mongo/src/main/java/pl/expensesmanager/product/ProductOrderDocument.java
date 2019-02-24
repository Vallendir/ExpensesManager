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
@Document(collection = "productOrder")
public class ProductOrderDocument {
	
	private String id;
	
	private ProductDocument product;
	
	private Integer quanity;
	
}
