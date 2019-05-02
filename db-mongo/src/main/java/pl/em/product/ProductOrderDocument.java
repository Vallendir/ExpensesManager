package pl.em.product;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class ProductOrderDocument {
	
	private String id;
	
	private String productId;
	
	private Integer quanity;
	
}
