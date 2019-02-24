package pl.expensesmanager.exception.business;

import pl.expensesmanager.exception.BusinessLogicException;

/**
 * Basic validation if some value is invalid
 */
public class PassedValueIsInvalidException extends BusinessLogicException {
	
	public PassedValueIsInvalidException(String message, String errorCode) {
		super(message, errorCode);
	}
	
}
