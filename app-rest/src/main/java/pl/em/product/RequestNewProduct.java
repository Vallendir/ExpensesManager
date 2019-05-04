package pl.em.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
class RequestNewProduct {
	
	private String name;
	
	private Double price;
	
	@JsonCreator
	public RequestNewProduct(@JsonProperty("name") String name, @JsonProperty("price") Double price) {
		this.name = name;
		this.price = price;
	}
	
}
