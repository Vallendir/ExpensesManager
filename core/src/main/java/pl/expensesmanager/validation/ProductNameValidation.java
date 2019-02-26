package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;
import pl.expensesmanager.exception.validation.ValidateTextException;

import static pl.expensesmanager.exception.ValidationExceptionFactory.productNameException;

@RequiredArgsConstructor
public class ProductNameValidation implements ValidationStrategy {
	
	private final String value;
	
	@Override
	public void validate() {
		try {
			validate(new StringValidation(value));
		} catch (ValidateTextException exception) {
			throw productNameException();
		}
	}
	
}
