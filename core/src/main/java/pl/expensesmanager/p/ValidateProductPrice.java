package pl.expensesmanager.p;

import pl.expensesmanager.b.Validator;

import java.util.Objects;

import static pl.expensesmanager.p.ProductExceptionFactory.productPriceInvalidException;

class ValidateProductPrice implements Validator<Product> {
	
	@Override
	public void validate(Product product) {
		var price = product.getPrice();
		
		if (Objects.isNull(price)) {
			productPriceInvalidException("Price cannot be null.");
		}
		if (price.isNaN()) {
			productPriceInvalidException("Price cannot be infinite.");
		}
	}
	
}
