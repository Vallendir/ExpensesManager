package pl.expensesmanager.validation;

import lombok.RequiredArgsConstructor;

import static pl.expensesmanager.exception.ValidationExceptionFactory.numberNANException;
import static pl.expensesmanager.exception.ValidationExceptionFactory.numberNullException;

/**
 * Class to validation double value.
 */
@RequiredArgsConstructor
public class DoubleValidation implements ValidationStrategy {
	
	private final Double value;
	
	@Override
	public void validate() {
		if (value == null) {
			numberNullException();
		}
		
		if (value.isNaN()) {
			numberNANException();
		}
	}
	
}
