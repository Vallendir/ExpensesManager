package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateNumberException;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productQuanityException;

@RequiredArgsConstructor
public class ProductQuanityValidation implements ValidationStrategy {
	
	private final Integer value;
	
	@Override
	public void validate() {
		try {
			validate(new IntegerValidation(value));
		} catch (ValidateNumberException exception) {
			throw productQuanityException();
		}
	}
	
}
