package pl.expensesmanager.exception.validation;

import pl.expensesmanager.exception.ValidationException;

/**
 * Basic validation of number value
 */
public final class ValidateNumberException extends ValidationException {
	
	public ValidateNumberException(String message, String errorCode) {
		super(message, EXCEPTION_ERROR_CODE_PREFIX + errorCode);
	}
	
}
