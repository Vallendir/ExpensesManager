package pl.expensesmanager.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDTO {
	
	private String id;
	
	private String productId;
	
	private Integer quanity;
	
	protected ProductOrderDTO map(ProductOrder order) {
		return ProductOrderDTO.builder()
		                      .id(order.getId())
		                      .productId(order.getProduct()
		                                      .getId())
		                      .quanity(order.getQuanity())
		                      .build();
	}
	
	protected ProductOrder map(ProductOrderDTO orderDTO) {
		Product product = new Product();
		product.setId(orderDTO.getProductId());
		
		ProductOrder order = ProductOrder.builder()
		                                 .product(product)
		                                 .quanity(orderDTO.getQuanity())
		                                 .build();
		order.setId(orderDTO.getId());
		
		return order;
	}
	
}
