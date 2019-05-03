package pl.em.product;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static pl.em.product.ProductExceptionFactory.*;

@RequiredArgsConstructor
final class ProductValidator {
	
	private final Product product;
	
	void validateName() {
		var name = product.getName();
		
		if (Objects.isNull(name)) {
			throw productNameIsNull();
		}
		
		if (StringUtils.isBlank(name)) {
			throw productNameIsEmpty();
		}
	}
	
	void validatePrice() {
		var price = product.getPrice();
		
		if (Objects.isNull(price)) {
			throw productPriceIsNull();
		}
		
		if (price.isInfinite() || price.isNaN()) {
			throw productPriceIsInvalid();
		}
	}
	
}
