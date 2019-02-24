package pl.expensesmanager.base;

import org.bson.types.ObjectId;
import pl.expensesmanager.product.Product;
import pl.expensesmanager.product.ProductDocument;
import pl.expensesmanager.product.ProductOrder;
import pl.expensesmanager.product.ProductOrderDocument;

/**
 * Basic storage adapter for mongo operations.
 */
public abstract class BaseMongoStorage implements IdValidatorPort<String> {
	
	@Override
	public boolean isValid(String id) {
		return ObjectId.isValid(id);
	}
	
	protected ProductDocument map(Product Product) {
		return ProductDocument.builder()
		                      .id(Product.getId())
		                      .name(Product.getName())
		                      .price(Product.getPrice())
		                      .build();
	}
	
	protected Product map(ProductDocument productDocument) {
		Product product = new Product();
		product.setId(productDocument.getId());
		product.setName(productDocument.getName());
		product.setPrice(productDocument.getPrice());
		
		return product;
	}
	
	protected ProductOrderDocument map(ProductOrder product) {
		return ProductOrderDocument.builder()
		                           .id(product.getId())
		                           .product(map(product.getProduct()))
		                           .quanity(product.getQuanity())
		                           .build();
	}
	
	protected ProductOrder map(ProductOrderDocument productDocument) {
		ProductOrder product = new ProductOrder();
		product.setId(productDocument.getId());
		product.setProduct(map(productDocument.getProduct()));
		product.setQuanity(productDocument.getQuanity());
		
		return product;
	}
	
}
