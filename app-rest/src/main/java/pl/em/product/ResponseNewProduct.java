package pl.em.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class ResponseNewProduct {
	
	private String id;
	
	private String name;
	
	private Double price;
	
}
