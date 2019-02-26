package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.product.ProductOrder;

import static pl.expensesmanager.exception.ValidationExceptionFactory.orderException;

@RequiredArgsConstructor
public class ProductOrderValidation implements ValidationStrategy {
	
	private final ProductOrder value;
	
	@Override
	public void validate() {
		if (value == null) {
			throw orderException();
		}
		
		validate(new ProductValidation(value.getProduct()));
		validate(new ProductQuanityValidation(value.getQuanity()));
	}
	
}
