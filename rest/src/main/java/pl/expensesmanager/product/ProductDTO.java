package pl.expensesmanager.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private String id;
	
	private String name;
	
	private Double price;
	
	protected static ProductDTO map(Product product) {
		return ProductDTO.builder()
		                 .id(product.getId())
		                 .name(product.getName())
		                 .price(product.getPrice())
		                 .build();
	}
	
	protected static Product map(ProductDTO productDTO) {
		Product product = Product.builder()
		                         .name(productDTO.getName())
		                         .price(productDTO.getPrice())
		                         .build();
		product.setId(productDTO.getId());
		
		return product;
	}
	
}
