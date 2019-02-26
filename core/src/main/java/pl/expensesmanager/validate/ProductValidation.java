package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.product.Product;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productException;

@RequiredArgsConstructor
public class ProductValidation implements ValidationStrategy {
	
	private final Product value;
	
	@Override
	public void validate() {
		if (value == null) {
			throw productException();
		}
		
		validate(new ProductNameValidation(value.getName()));
		validate(new ProductPriceValidation(value.getPrice()));
	}
	
}
