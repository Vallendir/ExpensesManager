package pl.em.order;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
final class OrderDocument {
	
	private String id;
	
	private String productId;
	
	private Integer quanity;
	
}
