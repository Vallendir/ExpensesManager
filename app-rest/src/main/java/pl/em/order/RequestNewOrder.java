package pl.em.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
class RequestNewOrder {
	
	private String productId;
	
	private Integer quanity;
	
	@JsonCreator
	public RequestNewOrder(@JsonProperty("productId") String productId, @JsonProperty("quanity") Integer quanity) {
		this.productId = productId;
		this.quanity = quanity;
	}
	
}
