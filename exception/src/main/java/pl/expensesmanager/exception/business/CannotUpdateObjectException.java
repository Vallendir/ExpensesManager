package pl.expensesmanager.exception.business;

import pl.expensesmanager.exception.BusinessLogicException;

/**
 * Basic validation if object could not be updated
 */
public class CannotUpdateObjectException extends BusinessLogicException {
	
	public CannotUpdateObjectException(String message, String errorCode) {
		super(message, errorCode);
	}
	
}
