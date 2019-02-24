package pl.expensesmanager.exception.internal;

import pl.expensesmanager.exception.InternalException;

/**
 * Basic validation of date
 */
public final class NoAccessException extends InternalException {
	
	public NoAccessException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
