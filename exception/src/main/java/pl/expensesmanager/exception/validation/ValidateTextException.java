package pl.expensesmanager.exception.validation;

import pl.expensesmanager.exception.ValidationException;

/**
 * Basic validation of text
 */
public class ValidateTextException extends ValidationException {
	
	public ValidateTextException(String message, String errorCode) {
		super(message, errorCode);
	}
	
}
