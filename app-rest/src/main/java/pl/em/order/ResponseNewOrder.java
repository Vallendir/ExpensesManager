package pl.em.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class ResponseNewOrder {
	
	private String id;
	
	private String productId;
	
	private Integer quanity;
	
}
