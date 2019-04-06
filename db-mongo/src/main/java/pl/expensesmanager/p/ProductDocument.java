package pl.expensesmanager.p;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
class ProductDocument {
	
	private String id;
	
	private String name;
	
	private Double price;
	
	static Product from(ProductDocument document) {
		return Product.builder()
		              .id(document.getId())
		              .name(document.getName())
		              .price(document.getPrice())
		              .build();
	}
	
	static ProductDocument from(Product product) {
		return ProductDocument.builder()
		                      .id(product.getId())
		                      .name(product.getName())
		                      .price(product.getPrice())
		                      .build();
	}
	
}
