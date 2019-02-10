package pl.expensesmanager.exception.validation;

import pl.expensesmanager.exception.ValidationException;

/**
 * Basic validation of date
 */
public final class ValidateDateException extends ValidationException {
	
	public ValidateDateException(String message, String errorCode) {
		super(message, EXCEPTION_ERROR_CODE_PREFIX + errorCode);
	}
	
}
