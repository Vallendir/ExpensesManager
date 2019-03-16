package pl.expensesmanager.exception.internal;

import pl.expensesmanager.exception.InternalException;

/**
 * Internal exceptino throws when there is no access
 */
public final class NoAccessException extends InternalException {
	
	public NoAccessException(String message, String errorCode, Throwable cause) {
		super(message, errorCode, cause);
	}
	
}
