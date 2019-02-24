package pl.expensesmanager.exception.business;

import pl.expensesmanager.exception.BusinessLogicException;

/**
 * Basic validation if object does not exists
 */
public class ObjectNotFoundException extends BusinessLogicException {
	
	public ObjectNotFoundException(String message, String errorCode) {
		super(message, errorCode);
	}
	
}
