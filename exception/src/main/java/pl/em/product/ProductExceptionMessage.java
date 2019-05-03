package pl.em.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum ProductExceptionMessage {
	PRODUCT_IS_NULL("product.is.null", "Product cannot be null."),
	PRODUCT_NOT_SAVED("product.not.saved", "Product cannot be saved."),
	
	PRODUCT_NAME_IS_NULL("product.name.is.null", "Product name cannot be null."),
	PRODUCT_NAME_IS_EMPTY("product.name.is.empty", "Product name cannot be empty."),
	
	PRODUCT_PRICE_IS_NULL("product.price.is.null", "Product price cannot be null."),
	PRODUCT_PRICE_IS_INVALID("product.price.is.invalid", "Product price cannot be infinite or is not a number.");
	
	private final String code;
	
	private final String message;
}
