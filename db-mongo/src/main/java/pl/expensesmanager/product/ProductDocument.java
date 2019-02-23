package pl.expensesmanager.product;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductDocument implements ProductPort {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}
