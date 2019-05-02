package pl.em.product;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class ProductDocument {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}