package pl.expensesmanager.p;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.b.Validator;

import java.util.Objects;

import static pl.expensesmanager.exception.BusinessLogicExceptionFactory.minBiggerThanMaxException;
import static pl.expensesmanager.p.ProductExceptionFactory.productPriceInvalidException;

@RequiredArgsConstructor
class ValidateProductPriceMinMax implements Validator<Product> {
	
	private final Double min;
	
	private final Double max;
	
	@Override
	public void validate(Product product) {
		if (min > max) {
			throw minBiggerThanMaxException();
		}
	}
	
}
