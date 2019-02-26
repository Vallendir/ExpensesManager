package pl.expensesmanager.validate;

import lombok.RequiredArgsConstructor;

import static pl.expensesmanager.exception.ValidationExceptionFactory.numberNullException;

/**
 * Class to validate integer value.
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
