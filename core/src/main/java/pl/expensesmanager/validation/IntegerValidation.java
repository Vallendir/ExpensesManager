package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;

import static pl.expensesmanager.exception.ValidationExceptionFactory.numberNullException;

/**
 * Class to validation integer value.
 */
@RequiredArgsConstructor
public class IntegerValidation implements ValidationStrategy {
	
	private final Integer value;
	
	@Override
	public void validate() {
		if (value == null) {
			numberNullException();
		}
	}
	
}
