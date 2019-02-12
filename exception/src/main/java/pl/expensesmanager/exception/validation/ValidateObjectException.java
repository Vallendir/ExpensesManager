package pl.expensesmanager.exception.validation;

import pl.expensesmanager.exception.ValidationException;

/**
 * Basic validation of object
 */
public final class ValidateObjectException extends ValidationException {
	
	public ValidateObjectException(String message, String errorCode) {
		super(message, errorCode);
	}
	
}
